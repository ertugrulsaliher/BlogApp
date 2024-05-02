package org.ertugrul.saliherspringblog.mapper;

import org.ertugrul.saliherspringblog.dto.requestDto.CategorySaveDTO;
import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CategoryResponseDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseDTO;
import org.ertugrul.saliherspringblog.entity.Category;
import org.ertugrul.saliherspringblog.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class );




    Post postSaveDtoToPost(PostSaveDTO dto);






    @Mapping(target = "userid", source = "post.user.id")
    @Mapping(target = "username", source = "post.user.name")
    PostResponseDTO postToPostResponseDTO(Post post);








}
