package com.Task.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

@Service
public class TodoService {

	private static int todoCount = 0;
	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(++todoCount, "sahil kumar", "Learn Spring Boot", LocalDate.now().plusMonths(3), false));
		todos.add(new Todo(++todoCount, "sahil kumar", "Learn  Microsevices", LocalDate.now().plusMonths(6), false));
		todos.add(new Todo(++todoCount, "sahil kumar", "Learn Spring Boot", LocalDate.now().plusMonths(8), false));
		todos.add(new Todo(++todoCount, "sahil kumar", "Learn Frontend", LocalDate.now().plusMonths(12), false));
	}

	public List<Todo> findbyUsername(String Username) {
		java.util.function.Predicate<? super Todo> predicate = todo -> todo.getUsername() .equalsIgnoreCase(Username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String desc, LocalDate targetDate, Boolean done) {
		Todo todo = new Todo(++todoCount, username, desc, targetDate, done);
		todos.add(todo);
	}

	public void deleteTodo(int id) {

		java.util.function.Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);

	}

	public Todo updateTodo(int id) {
		java.util.function.Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateList(@Valid Todo todo) {
		
		LocalDate date = todo.getTargetDate();
		deleteTodo(todo.getId());
//		todo.setTargetDate(date);
		todos.add(todo);

	}

}
