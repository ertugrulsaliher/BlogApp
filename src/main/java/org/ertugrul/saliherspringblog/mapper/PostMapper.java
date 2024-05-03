package org.ertugrul.saliherspringblog.mapper;

import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseDetailedDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseOnlyPostsDTO;
import org.ertugrul.saliherspringblog.entity.Post;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class );




    Post postSaveDtoToPost(PostSaveDTO dto);






    @Mapping(target = "userid", source = "post.user.id")
    @Mapping(target = "username", source = "post.user.name")
    @Mapping(target = "comment", ignore = true)
    PostResponseDetailedDTO postToPostResponseDetailedDTO(Post post);

    @Mapping(target = "userid", source = "post.user.id")
    @Mapping(target = "username", source = "post.user.name")
    PostResponseOnlyPostsDTO postToPostResponseOnlyPostsDTO(Post post);




}
