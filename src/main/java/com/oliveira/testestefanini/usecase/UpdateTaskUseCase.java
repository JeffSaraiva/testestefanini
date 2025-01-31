package com.oliveira.testestefanini.usecase;

import com.oliveira.testestefanini.domain.Task;
import com.oliveira.testestefanini.port.out.TaskRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {

	private final TaskRepositoryPort taskRepository;

	public UpdateTaskUseCase(TaskRepositoryPort taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task execute(int id, String title, String description, String status) {
		Task task = new Task(title, description, status);
		task.setId(id);
		return taskRepository.save(task); // Atualiza a tarefa
	}
}