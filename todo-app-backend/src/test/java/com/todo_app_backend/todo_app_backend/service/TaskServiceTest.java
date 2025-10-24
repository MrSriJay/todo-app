package com.todo_app_backend.todo_app_backend.service;

import com.todo_app_backend.todo_app_backend.dto.TaskRequest;
import com.todo_app_backend.todo_app_backend.dto.TaskResponse;
import com.todo_app_backend.todo_app_backend.entity.Task;
import com.todo_app_backend.todo_app_backend.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("TaskService Unit Tests")
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskSERVICE;

    private Task task;
    private TaskRequest taskRequest;

    @BeforeEach
    void setUp() {
        taskRequest = TaskRequest.builder()
                .title("Test Task")
                .description("Test Description")
                .build();

        task = Task.builder()
                .id(1L)
                .title("Test Task")
                .description("Test Description")
                .completed(false)
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Test
    @DisplayName("Should create task successfully")
    void createTask_ShouldReturnTaskResponse() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        TaskResponse response = taskSERVICE.createTask(taskRequest);
        assertNotNull(response);
        assertEquals("Test Task", response.getTitle());
        assertEquals("Test Description", response.getDescription());
        assertFalse(response.isCompleted());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Should return top 5 recent incomplete tasks")
    void getRecentTasks_ShouldReturnTop5IncompleteTasks() {
        Task task1 = Task.builder().id(1L).title("Task 1").completed(false).build();
        Task task2 = Task.builder().id(2L).title("Task 2").completed(false).build();
        List<Task> mockTasks = Arrays.asList(task1, task2);
        when(taskRepository.findTop5RecentIncompleteTasks()).thenReturn(mockTasks);
        List<TaskResponse> result = taskSERVICE.getRecentTasks();
        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getTitle());
        verify(taskRepository, times(1)).findTop5RecentIncompleteTasks();
    }

    @Test
    @DisplayName("Should mark task as completed")
    void completeTask_ShouldMarkTaskAsCompleted() {

        Task incompleteTask = task.toBuilder().completed(false).build();
        Task completedTask = task.toBuilder().completed(true).build();
        when(taskRepository.findById(1L)).thenReturn(Optional.of(incompleteTask));
        when(taskRepository.save(any(Task.class))).thenReturn(completedTask);
        TaskResponse response = taskSERVICE.completeTask(1L);
        assertTrue(response.isCompleted());
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Should throw exception when task not found")
    void completeTask_ShouldThrowWhenTaskNotFound() {
        when(taskRepository.findById(999L)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            taskSERVICE.completeTask(999L);
        });
        assertEquals("Task not found", exception.getMessage());
        verify(taskRepository, never()).save(any());
    }
}