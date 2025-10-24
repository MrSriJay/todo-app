package com.todo_app_backend.todo_app_backend.repository;


import com.todo_app_backend.todo_app_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.completed = false ORDER BY t.createdAt DESC")
    List<Task> findRecentIncompleteTasks();

    @Query("SELECT t FROM Task t WHERE t.completed = false ORDER BY t.createdAt DESC LIMIT 5")
    List<Task> findTop5RecentIncompleteTasks();
}