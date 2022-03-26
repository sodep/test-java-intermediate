package com.sodep;

import com.sodep.entities.Assignee;
import com.sodep.entities.Task;
import com.sodep.services.AssigneeService;
import com.sodep.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MockDataApp implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Autowired
    private AssigneeService assigneeService;

    @Override
    public void run(String...args) throws Exception {

        //		mock data
        Assignee a1 = new Assignee(1l, "Enzo Nunez", "enunez@gmail.com", Date.from(Instant.now()));
        Assignee a2 = new Assignee(2l, "Jane Doe", "jdoe@gmail.com", Date.from(Instant.now()));
        Assignee a3 = new Assignee(3l, "Steve Jones", "sjones@gmail.com", Date.from(Instant.now()));

        LocalDateTime due1 = LocalDateTime.of(2022, 3, 27, 18, 00, 30);
        LocalDateTime due2 = LocalDateTime.of(2022, 3, 27, 18, 00, 30);
        LocalDateTime due3 = LocalDateTime.of(2022, 3, 27, 18, 00, 30);

        assigneeService.createAssignee(a1);
        assigneeService.createAssignee(a2);
        assigneeService.createAssignee(a3);

        Task t1 = new Task(1l, "Implement REST service for task list", a1, Date.from(due1.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t2 = new Task(2l, "Find first customer for task list app.", a2, Date.from(due2.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t3 = new Task(3l, "Implements OpenAPI Swagger", a3, Date.from(due3.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t4 = new Task(4l, "Implements Reactive Spring", a1, Date.from(due3.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t5 = new Task(5l, "Implements Spring Security JWT", a1, Date.from(due3.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t6 = new Task(6l, "Implements Front End With Vuejs", a1, Date.from(due3.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t7 = new Task(7l, "Implements Proxy with Nodejs", a1, Date.from(due3.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t8 = new Task(8l, "Implements Front End With Angular", a1, Date.from(due3.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );
        Task t9 = new Task(9l, "Implements Front End With React", a1, Date.from(due3.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(Instant.now()), Date.from(Instant.now()) );

        List<Task> taskList = new ArrayList<>();
        taskList.add(t1);
        taskList.add(t2);
        taskList.add(t3);
        taskList.add(t4);
        taskList.add(t5);
        taskList.add(t6);
        taskList.add(t7);
        taskList.add(t8);
        taskList.add(t9);

//        taskService.createTasks(taskList);
        taskService.createTask(t1);
        taskService.createTask(t2);
        taskService.createTask(t3);
        taskService.createTask(t4);
        taskService.createTask(t5);
        taskService.createTask(t6);
        taskService.createTask(t7);
        taskService.createTask(t8);
        taskService.createTask(t9);
    }
}