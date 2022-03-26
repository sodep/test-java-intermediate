package com.sodep.services;

import com.sodep.entities.Assignee;
import com.sodep.entities.Task;
import com.sodep.repositories.AssigneeRepository;
import com.sodep.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AssigneeRepository assigneeRepository;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id);
    }

    public boolean createTask(Task task) {
        boolean create = true;
        Assignee assignee = assigneeRepository.findById(task.getAssignee().getId());
        int taskSizeCount = assignee.getTasks().size();
        System.out.println("task size on assignee with id " + assignee.getId() + " = " + taskSizeCount);
        System.out.println(taskSizeCount);
        if (taskSizeCount < 5) {
            System.out.println("can create task");
        } else {
            System.out.println("can not create task");
            create = false;
        }
        if (create) {
            assignee.getTasks().add(task);
            assigneeRepository.save(assignee);
            taskRepository.save(task);
        }
        return create;
    }

    public void createTasks(List<Task> tasksList) {
        taskRepository.save(tasksList);
    }
}
