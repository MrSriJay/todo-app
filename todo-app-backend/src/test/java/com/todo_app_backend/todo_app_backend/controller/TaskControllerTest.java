package com.todo_app_backend.todo_app_backend.controller;

import com.todo_app_backend.todo_app_backend.dto.TaskRequest;
import com.todo_app_backend.todo_app_backend.dto.TaskResponse;
import com.todo_app_backend.todo_app_backend.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
@DisplayName("TaskController Integration Tests")
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /api/tasks - Should create task")
    void createTask_ShouldReturnCreatedTask() throws Exception {
        TaskRequest request = TaskRequest.builder()
                .title("New Task")
                .description("Description")
                .build();
        TaskResponse response = TaskResponse.builder()
                .id(1L)
                .title("New Task")
                .description("Description")
                .completed(false)
                .createdAt(LocalDateTime.now())
                .build();

        when(taskService.createTask(any(TaskRequest.class))).thenReturn(response);
        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Task"))
                .andExpect(jsonPath("$.completed").value(false));

        verify(taskService, times(1)).createTask(any(TaskRequest.class));
    }

    @Test
    @DisplayName("GET /api/tasks - Should return recent 5 tasks")
    void getRecentTasks_ShouldReturnTaskList() throws Exception {
        TaskResponse task1 = TaskResponse.builder().id(1L).title("Task 1").completed(false).build();
        TaskResponse task2 = TaskResponse.builder().id(2L).title("Task 2").completed(false).build();
        List<TaskResponse> tasks = Arrays.asList(task1, task2);
        when(taskService.getRecentTasks()).thenReturn(tasks);
        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Task 1"));

        verify(taskService, times(1)).getRecentTasks();
    }

    @Test
    @DisplayName("PUT /api/tasks/{id}/complete - Should mark task as done")
    void completeTask_ShouldReturnCompletedTask() throws Exception {
        TaskResponse completedTask = TaskResponse.builder()
                .id(1L)
                .title("Done Task")
                .completed(true)
                .build();

        when(taskService.completeTask(1L)).thenReturn(completedTask);
        mockMvc.perform(put("/api/tasks/1/complete"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.completed").value(true));

        verify(taskService, times(1)).completeTask(1L);
    }

    @Test
    @DisplayName("POST /api/tasks - Should return 400 if title missing")
    void createTask_ShouldReturn400_WhenTitleMissing() throws Exception {
        TaskRequest invalidRequest = TaskRequest.builder()
                .title("")
                .description("No title")
                .build();
        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());

        verify(taskService, never()).createTask(any());
    }
}
