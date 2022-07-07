package com.andersonjunior.todolistspring.repository;

import com.andersonjunior.todolistspring.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
