package org.ertugrul.saliherspringblog.repository;

import org.ertugrul.saliherspringblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost_id(Long postid);
}
