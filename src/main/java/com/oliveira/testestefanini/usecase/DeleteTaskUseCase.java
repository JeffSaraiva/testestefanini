package com.oliveira.testestefanini.usecase;

import com.oliveira.testestefanini.port.out.TaskRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {

	private final TaskRepositoryPort taskRepository;

	public DeleteTaskUseCase(TaskRepositoryPort taskRepository) {
		this.taskRepository = taskRepository;
	}

	public void execute(int id) {
		taskRepository.deleteById(id);
	}
}