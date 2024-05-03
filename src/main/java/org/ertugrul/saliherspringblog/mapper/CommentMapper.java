package org.ertugrul.saliherspringblog.mapper;

import org.ertugrul.saliherspringblog.dto.requestDto.CommentSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CommentResponseDTO;
import org.ertugrul.saliherspringblog.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class );




    Comment commentSaveDTOToComment(CommentSaveDTO dto);

    @Mapping(target = "userid",source = "comment.user.id")
    @Mapping(target = "username" ,source = "comment.user.name")
    @Mapping(target = "postid" ,source = "comment.post.id")
    CommentResponseDTO commentToCommentResponseDTO(Comment comment);








}
