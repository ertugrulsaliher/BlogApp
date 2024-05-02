package org.ertugrul.saliherspringblog.service;

import org.ertugrul.saliherspringblog.entity.Comment;
import org.ertugrul.saliherspringblog.repository.CommentRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment,Long> {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }
}
