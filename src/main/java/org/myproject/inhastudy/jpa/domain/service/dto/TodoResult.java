package org.myproject.inhastudy.jpa.domain.service.dto;

import org.myproject.inhastudy.jpa.domain.entity.Todo;
import org.myproject.inhastudy.jpa.domain.entity.TodoStatus;

public record TodoResult(
        Long id,
        String title,
        TodoStatus status
) {
    public static TodoResult from(Todo todo) {
        return new TodoResult(todo.getId(), todo.getTitle(), todo.getTodoStatus());
    }
}