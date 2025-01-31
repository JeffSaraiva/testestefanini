package com.oliveira.testestefanini.usecase;

import com.oliveira.testestefanini.domain.Task;
import com.oliveira.testestefanini.port.out.TaskRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTasksUseCase {

	private final TaskRepositoryPort taskRepository;

	public GetAllTasksUseCase(TaskRepositoryPort taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> execute() {
		return taskRepository.findAll();
	}
}