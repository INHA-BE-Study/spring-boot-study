package org.myproject.inhastudy.jpa.domain.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myproject.inhastudy.jpa.domain.controller.dto.TodoRequest;
import org.myproject.inhastudy.jpa.domain.controller.dto.TodoResponse;
import org.myproject.inhastudy.jpa.domain.entity.Todo;
import org.myproject.inhastudy.jpa.domain.service.TodoService;
import org.myproject.inhastudy.jpa.domain.service.dto.TodoCommand;
import org.myproject.inhastudy.jpa.domain.service.dto.TodoResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody @Valid TodoRequest request) {
        TodoCommand command = new TodoCommand(request.title(), request.description()); // Controller가 직접 변환
        TodoResult result = todoService.create(command);    // Service 호출
        Todo todo = todoService.findById(result.id());      // 완성된 Todo 조회
        return ResponseEntity.ok(TodoResponse.from(todo));  // Entity → Response 변환
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> findById(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        return ResponseEntity.ok(TodoResponse.from(todo));
    }
}
