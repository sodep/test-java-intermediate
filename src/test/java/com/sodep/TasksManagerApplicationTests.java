package com.sodep;

import com.sodep.controllers.TaskController;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.Assert.assertEquals;

@WebMvcTest(TaskController.class)
public class TasksManagerApplicationTests {

	@Test
	public void hiTest() {
		TaskController taskController = new TaskController();
		String resp = taskController.hiTest("Enzo");
		assertEquals("HI Enzo",resp);
	}





}
