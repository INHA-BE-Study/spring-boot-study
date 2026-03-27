package org.myproject.inhastudy.jpa.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myproject.inhastudy.jpa.domain.entity.Tag;
import org.myproject.inhastudy.jpa.domain.entity.Todo;
import org.myproject.inhastudy.jpa.domain.repository.TagRepository;
import org.myproject.inhastudy.jpa.domain.repository.TodoRepository;
import org.myproject.inhastudy.jpa.domain.service.dto.TodoCommand;
import org.myproject.inhastudy.jpa.domain.service.dto.TodoResult;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TagRepository tagRepository;

    @Transactional
    public TodoResult create(TodoCommand command) {  // Entity 대신 TodoResult 반환
        Todo todo = Todo.create(command.title(), command.description());
        todoRepository.save(todo);
        return TodoResult.from(todo);  // Entity → Result 변환 후 반환
    }

    @Transactional
    public void addTag(Long todoId, String tagName) {
        Todo todo = todoRepository.findById(todoId).orElseThrow();
        Tag tag = Tag.create(tagName, todo);
        tagRepository.save(tag); // TagRepository로 직접 저장
    }

    public Todo findById(Long id) {  // 내부 조회용 — Entity 반환 (Service 내부에서만 사용)
        return todoRepository.findById(id).orElseThrow();
    }
}