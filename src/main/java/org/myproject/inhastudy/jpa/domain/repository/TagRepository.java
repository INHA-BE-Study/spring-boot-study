package org.myproject.inhastudy.jpa.domain.repository;

import org.myproject.inhastudy.jpa.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
