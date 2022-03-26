package com.sodep.services;

import com.sodep.entities.Assignee;
import com.sodep.entities.Task;
import com.sodep.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("assigneeService")
public class AssigneeService {

    @Autowired
    private AssigneeRepository assigneeRepository;

    public void createAssignee(Assignee assignee) {
        assigneeRepository.save(assignee);
    }
}
