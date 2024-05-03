package org.ertugrul.saliherspringblog.service;

import org.ertugrul.saliherspringblog.dto.requestDto.CommentSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CommentResponseDTO;
import org.ertugrul.saliherspringblog.entity.Comment;
import org.ertugrul.saliherspringblog.entity.User;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.exception.ErrorType;
import org.ertugrul.saliherspringblog.mapper.CommentMapper;
import org.ertugrul.saliherspringblog.repository.CommentRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.ertugrul.saliherspringblog.exception.ErrorType.*;

@Service
public class CommentService extends ServiceManager<Comment,Long> {
    private final CommentRepository commentRepository;
    private final UserService userService;
    @Lazy
    @Autowired
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService) {
        super(commentRepository);
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    public CommentResponseDTO saveDTO(CommentSaveDTO commentSaveDTO) {
        Comment savedComment = save(Comment.builder()
                .user(userService.findById(commentSaveDTO.userid()).orElseThrow(() -> new BlogAppException(USER_NOT_FOUND)))
                .post(postService.findById(commentSaveDTO.postid()).orElseThrow(() -> new BlogAppException(POST_NOT_FOUND)))
                .content(commentSaveDTO.content())
                .build());


        return CommentMapper.INSTANCE.commentToCommentResponseDTO(savedComment);
    }


    public List<CommentResponseDTO> findAllDTO() {
        List<CommentResponseDTO> commentResponseDTOList = new ArrayList<>();
        findAll().forEach(comment -> {
            commentResponseDTOList.add(CommentMapper.INSTANCE.commentToCommentResponseDTO(comment));
        });
        if(commentResponseDTOList.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_COMMENT_IN_THE_DATABASE);
        }
        return commentResponseDTOList;
    }

    public List<CommentResponseDTO> getPostsCommentList(Long id) {
        List<CommentResponseDTO> commentResponseDTOList = new ArrayList<>();
        List<Comment> commentList = commentRepository.findAllByPost_id(id);
        if(commentList.isEmpty()){
            return commentResponseDTOList;
        } else{
         commentList.forEach(comment -> {
             commentResponseDTOList.add(CommentMapper.INSTANCE.commentToCommentResponseDTO(comment));
         });
            return commentResponseDTOList;
        }

    }
}
