package org.myproject.inhastudy.jpa.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todos")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoStatus todoStatus;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags = new ArrayList<>();

    public static Todo create(String title, String description) {
        Todo todo = new Todo();
        todo.title = title;
        todo.description = description;
        todo.todoStatus = TodoStatus.TODO;
        return todo;
    }

    public void complete() {
        if (this.todoStatus == TodoStatus.DONE) {
            throw new IllegalStateException("이미 완료된 항목입니다.");
        }
        this.todoStatus = TodoStatus.DONE;
        // @Transactional 안에서 호출하면 save() 없이도 UPDATE 쿼리가 나감 — 아래에서 확인
    }

    public void startProgress() {
        if (this.todoStatus != TodoStatus.TODO) {
            throw new IllegalStateException("TODO 상태에서만 진행 중으로 변경 가능합니다.");
        }
        this.todoStatus = TodoStatus.IN_PROGRESS;
    }
}