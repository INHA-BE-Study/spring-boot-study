package org.myproject.inhastudy.jpa.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tags")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public static Tag create(String name, Todo todo) {
        Tag tag = new Tag();
        tag.name = name;
        tag.todo = todo;
        todo.getTags().add(tag); // 편의 메서드 — 양쪽 동시에 세팅
        return tag;
    }
}