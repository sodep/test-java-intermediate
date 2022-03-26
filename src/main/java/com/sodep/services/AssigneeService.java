package com.sodep.services;

import com.sodep.entities.Assignee;
import com.sodep.entities.Task;
import com.sodep.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("assigneeService")
public class AssigneeService {

    @Autowired
    private AssigneeRepository assigneeRepository;

    public Assignee findById(Long id) {
        return assigneeRepository.findById(id);
    }

    public List<Assignee> listAll() {
        return assigneeRepository.findAll();
    }

    public void createAssignee(Assignee assignee) {
        assigneeRepository.save(assignee);
    }

}
