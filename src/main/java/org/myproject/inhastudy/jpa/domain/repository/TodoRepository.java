package org.myproject.inhastudy.jpa.domain.repository;

import org.myproject.inhastudy.jpa.domain.entity.Todo;
import org.myproject.inhastudy.jpa.domain.entity.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByTodoStatus(TodoStatus status);
}
