package com.taskmanagement.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.fullstackbackend.model.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
