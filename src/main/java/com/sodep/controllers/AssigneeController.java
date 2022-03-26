package com.sodep.controllers;

import com.sodep.entities.Assignee;
import com.sodep.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignees")
public class AssigneeController {

    @Autowired
    private AssigneeService assigneeService;

    @GetMapping
    private ResponseEntity<?> listAssignees() {
        List<Assignee> assignees = assigneeService.listAll();
        if (assignees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(assignees, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<?> findAssigneesById(@PathVariable("id") Long id) {
        Assignee assignee = assigneeService.findById(id);
        if (assignee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assignee, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    private ResponseEntity<?> createAssignee(@RequestBody Assignee assignee) {
        assigneeService.createAssignee(assignee);
        return new ResponseEntity<>(assignee, HttpStatus.CREATED);
    }
}
