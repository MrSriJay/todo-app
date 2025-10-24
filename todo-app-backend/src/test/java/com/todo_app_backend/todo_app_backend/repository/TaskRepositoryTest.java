package com.todo_app_backend.todo_app_backend.repository;

import com.todo_app_backend.todo_app_backend.entity.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("TaskRepository Integration Tests")
class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void findTop5RecentIncompleteTasks_ShouldReturnLimitedIncompleteTasks() {
        // Given
        for (int i = 1; i <= 5; i++) {
            Task task = Task.builder()
                    .title("Task " + i)
                    .description("Desc " + i)
                    .completed(false)
                    .build();
            entityManager.persistAndFlush(task);
        }

        for (int i = 6; i <= 7; i++) {
            Task task = Task.builder()
                    .title("Completed " + i)
                    .completed(true)
                    .build();
            entityManager.persistAndFlush(task);
        }

        // When
        List<Task> result = taskRepository.findTop5RecentIncompleteTasks();

        // Then
        assertThat(result).hasSize(5);
        assertThat(result).allMatch(task -> !task.isCompleted());
        assertThat(result.get(0).getTitle()).isEqualTo("Task 5");
    }
}