//package com.todo_app_backend.todo_app_backend.repository;
//
//import com.todo_app_backend.todo_app_backend.entity.Task;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@ActiveProfiles("test")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class TaskRepositoryTest {
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    private Task task1, task2, task3, task4, task5, task6;
//
//    @BeforeEach
//    void setUp() {
//        taskRepository.deleteAll();
//
//        task1 = Task.builder()
//                .title("Task 1")
//                .description("First task")
//                .completed(false)
//                .createdAt(LocalDateTime.now().minusHours(10))
//                .build();
//
//        task2 = Task.builder()
//                .title("Task 2")
//                .description("Second task")
//                .completed(false)
//                .createdAt(LocalDateTime.now().minusHours(8))
//                .build();
//
//        task3 = Task.builder()
//                .title("Task 3")
//                .completed(false)
//                .createdAt(LocalDateTime.now().minusHours(6))
//                .build();
//
//        task4 = Task.builder()
//                .title("Task 4")
//                .completed(false)
//                .createdAt(LocalDateTime.now().minusHours(4))
//                .build();
//
//        task5 = Task.builder()
//                .title("Task 5")
//                .completed(false)
//                .createdAt(LocalDateTime.now().minusHours(2))
//                .build();
//
//        task6 = Task.builder()
//                .title("Task 6")
//                .completed(true)
//                .createdAt(LocalDateTime.now().minusHours(1))
//                .build();
//
//        taskRepository.saveAll(List.of(task1, task2, task3, task4, task5, task6));
//    }
//
//    @Test
//    @Order(1)
//    void shouldFindTop5RecentIncompleteTasks() {
//        List<Task> tasks = taskRepository.findTop5RecentIncompleteTasks();
//
//        assertThat(tasks).hasSize(5);
//        assertThat(tasks.get(0).getTitle()).isEqualTo("Task 5");
//        assertThat(tasks.get(4).getTitle()).isEqualTo("Task 1");
//        assertThat(tasks).extracting(Task::isCompleted).containsOnly(false);
//    }
//
//    @Test
//    @Order(2)
//    void shouldReturnLessThan5WhenFewerIncompleteTasks() {
//        taskRepository.deleteAll();
//        Task single = Task.builder().title("Only").completed(false).build();
//        taskRepository.save(single);
//
//        List<Task> tasks = taskRepository.findTop5RecentIncompleteTasks();
//        assertThat(tasks).hasSize(1);
//    }
//
//    @Test
//    @Order(3)
//    void shouldExcludeCompletedTasks() {
//        List<Task> tasks = taskRepository.findTop5RecentIncompleteTasks();
//        assertThat(tasks).noneMatch(Task::isCompleted);
//    }
//}