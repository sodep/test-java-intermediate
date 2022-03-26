package com.sodep.controllers;

import com.sodep.entities.Task;
import com.sodep.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    private ResponseEntity<?> listTasks() {
        List<Task> tasks = taskService.listAll();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<?> findTaskById(@PathVariable("id") Long id) {
        Task task = taskService.findById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    private ResponseEntity<?> createTask(@RequestBody Task task) {
        boolean created = taskService.createTask(task);
        if (created) {
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Can't create more than five task for person", HttpStatus.BAD_REQUEST);
        }
    }
}
