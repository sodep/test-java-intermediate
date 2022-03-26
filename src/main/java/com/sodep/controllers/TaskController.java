package com.sodep.controllers;

import com.sodep.entities.Task;
import com.sodep.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<?> listTasks() {
        List<Task> tasks = taskService.listAll();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private ResponseEntity<?> findTaskById(@PathVariable("id") Long id) {
        Task task = taskService.findById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    private ResponseEntity<?> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
