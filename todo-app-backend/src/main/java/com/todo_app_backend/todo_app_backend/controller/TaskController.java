package com.todo_app_backend.todo_app_backend.controller;


import com.todo_app_backend.todo_app_backend.dto.TaskRequest;
import com.todo_app_backend.todo_app_backend.dto.TaskResponse;
import com.todo_app_backend.todo_app_backend.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Tag(name = "Task Management", description = "Manage your to-do tasks")
public class TaskController {

    private final TaskService taskService;

    @Operation(
            summary = "Create a new task",
            description = "Create a new to-do task with title and description"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input - Title is required"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest request) {
        TaskResponse response = taskService.createTask(request);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get recent incomplete tasks",
            description = "Get the most recent 5 incomplete tasks"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getRecentTasks() {
        List<TaskResponse> tasks = taskService.getRecentTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(
            summary = "Mark task as completed",
            description = "Mark a specific task as completed by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task marked as completed"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}/complete")
    public ResponseEntity<TaskResponse> completeTask(
            @Parameter(description = "Task ID", required = true, example = "1")
            @PathVariable Long id) {
        TaskResponse response = taskService.completeTask(id);
        return ResponseEntity.ok(response);
    }
}