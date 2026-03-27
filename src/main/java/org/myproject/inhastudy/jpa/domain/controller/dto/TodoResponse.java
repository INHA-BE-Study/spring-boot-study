package org.myproject.inhastudy.jpa.domain.controller.dto;

import org.myproject.inhastudy.jpa.domain.entity.Tag;
import org.myproject.inhastudy.jpa.domain.entity.Todo;

import java.util.List;

public record TodoResponse(
        Long id,
        String title,
        String status,
        List<String> tags
) {
    public static TodoResponse from(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getTodoStatus().name(),
                todo.getTags().stream().map(Tag::getName).toList()
        );
    }
}
