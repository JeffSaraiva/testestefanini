package com.oliveira.testestefanini.adapter.in;

import com.oliveira.testestefanini.domain.Task;
import com.oliveira.testestefanini.usecase.CreateTaskUseCase;
import com.oliveira.testestefanini.usecase.DeleteTaskUseCase;
import com.oliveira.testestefanini.usecase.GetAllTasksUseCase;
import com.oliveira.testestefanini.usecase.GetTaskByIdUseCase;
import com.oliveira.testestefanini.usecase.UpdateTaskUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final CreateTaskUseCase createTaskUseCase;
	private final GetAllTasksUseCase getAllTasksUseCase;
	private final GetTaskByIdUseCase getTaskByIdUseCase;
	private final UpdateTaskUseCase updateTaskUseCase;
	private final DeleteTaskUseCase deleteTaskUseCase;

	public TaskController(CreateTaskUseCase createTaskUseCase, GetAllTasksUseCase getAllTasksUseCase,
			GetTaskByIdUseCase getTaskByIdUseCase, UpdateTaskUseCase updateTaskUseCase,
			DeleteTaskUseCase deleteTaskUseCase) {
		this.createTaskUseCase = createTaskUseCase;
		this.getAllTasksUseCase = getAllTasksUseCase;
		this.getTaskByIdUseCase = getTaskByIdUseCase;
		this.updateTaskUseCase = updateTaskUseCase;
		this.deleteTaskUseCase = deleteTaskUseCase;
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return createTaskUseCase.execute(task.getTitle(), task.getDescription(), task.getStatus());
	}

	@GetMapping
	public List<Task> getAllTasks() {
		return getAllTasksUseCase.execute();
	}

	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable int id) {
		return getTaskByIdUseCase.execute(id);
	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable int id, @RequestBody Task task) {
		return updateTaskUseCase.execute(id, task.getTitle(), task.getDescription(), task.getStatus());
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable int id) {
		deleteTaskUseCase.execute(id);
	}
}