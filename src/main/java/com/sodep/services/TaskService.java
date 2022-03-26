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
        boolean created = true;
        System.out.println(task.getAssignee().getTasks().size() );
        if (task.getAssignee().getTasks().size() <= 5){
            System.out.println("*********************** puede insertar task");
            taskRepository.save(task);
//            Assignee newAssignee = assigneeRepository.findById(task.getAssignee().getId());
//            newAssignee.getTasks().add(task);
//            assigneeRepository.save(newAssignee);
        }else{
            System.out.println("*********************** no puede insertar task");
            created = false;
            throw new RuntimeException("No puede guardar mas de 5 tareas a un usuario");
        }
        return created;
    }

    public void createTasks(List<Task> tasksList) {
        taskRepository.save(tasksList);
    }
}
