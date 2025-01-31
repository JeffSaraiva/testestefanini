package com.oliveira.testestefanini.usecase;

import com.oliveira.testestefanini.domain.Task;
import com.oliveira.testestefanini.port.out.TaskRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTaskByIdUseCase {

	private final TaskRepositoryPort taskRepository;

	public GetTaskByIdUseCase(TaskRepositoryPort taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task execute(int id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.orElseThrow(() -> new RuntimeException("Task not found")); // Ou qualquer exceção personalizada
	}
}