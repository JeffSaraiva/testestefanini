package com.oliveira.testestefanini.port.out;

import com.oliveira.testestefanini.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {

	Task save(Task task);

	Optional<Task> findById(int id);

	List<Task> findAll();

	void deleteById(int id);
}