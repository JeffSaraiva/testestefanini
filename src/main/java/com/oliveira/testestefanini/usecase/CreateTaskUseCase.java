
package com.oliveira.testestefanini.usecase;

import com.oliveira.testestefanini.domain.Task;
import com.oliveira.testestefanini.port.out.TaskRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {

	private final TaskRepositoryPort taskRepository;

	public CreateTaskUseCase(TaskRepositoryPort taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task execute(String title, String description, String status) {
		Task task = new Task(title, description, status);
		return taskRepository.save(task);
	}
}