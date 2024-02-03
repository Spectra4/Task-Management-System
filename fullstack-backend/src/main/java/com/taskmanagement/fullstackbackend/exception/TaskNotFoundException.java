package com.taskmanagement.fullstackbackend.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(int id){
        super("Could not found the task with id "+ id);
    }
}
