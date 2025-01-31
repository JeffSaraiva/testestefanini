package com.oliveira.testestefanini.adapter.out.jdbc;

import com.oliveira.testestefanini.domain.Task;
import com.oliveira.testestefanini.port.out.TaskRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryJdbcImpl implements TaskRepositoryPort {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TaskRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Task save(Task task) {
		if (task.getId() == 0) {
			// Inserir nova tarefa
			String sql = "INSERT INTO task (title, description, status, date_task) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.getStatus(), task.getDateTask());
		} else {
			// Atualizar tarefa existente
			String sql = "UPDATE task SET title = ?, description = ?, status = ?, date_task = ? WHERE id = ?";
			jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.getStatus(), task.getDateTask(),
					task.getId());
		}
		return task;
	}

	@Override
	public Optional<Task> findById(int id) {
		String sql = "SELECT * FROM task WHERE id = ?";
		Task task = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Task t = new Task(rs.getString("title"), rs.getString("description"), rs.getString("status"));
			t.setId(rs.getInt("id"));
			t.setDateTask(rs.getDate("date_task"));
			return t;
		}, id);

		return Optional.ofNullable(task);
	}

	@Override
	public List<Task> findAll() {
		String sql = "SELECT * FROM task";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Task task = new Task(rs.getString("title"), rs.getString("description"), rs.getString("status"));
			task.setId(rs.getInt("id"));
			task.setDateTask(rs.getDate("date_task"));
			return task;
		});
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM task WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}