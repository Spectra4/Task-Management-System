package com.taskmanagement.fullstackbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.taskmanagement.fullstackbackend.exception.TaskNotFoundException;
import com.taskmanagement.fullstackbackend.model.Task;
import com.taskmanagement.fullstackbackend.repository.TaskRepository;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/task")
    Task newTask(@RequestBody Task newTask) {
        return taskRepository.save(newTask);
    }

    @GetMapping("/tasks")
    List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
    Task getTaskById(@PathVariable int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @PutMapping("/task/{id}")
    Task updateTask(@RequestBody Task newTask, @PathVariable int id) {
        return taskRepository.findById((int) id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDetails(newTask.getDetails());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new TaskNotFoundException(id));
    }

    @DeleteMapping("/task/{id}")
    String deleteTask(@PathVariable int id){
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
        return  "Task with id "+id+" has been deleted success.";
    }



}
