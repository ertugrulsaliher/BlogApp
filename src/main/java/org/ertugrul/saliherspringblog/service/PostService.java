package org.ertugrul.saliherspringblog.service;

import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseDTO;
import org.ertugrul.saliherspringblog.entity.Post;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.mapper.PostMapper;
import org.ertugrul.saliherspringblog.repository.PostRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.ertugrul.saliherspringblog.exception.ErrorType.*;

@Service

public class PostService extends ServiceManager<Post,Long> {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    public PostService(PostRepository postRepository, CategoryService categoryService, UserService userService) {
        super(postRepository);
        this.postRepository = postRepository;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    public PostResponseDTO saveDTO(PostSaveDTO postSaveDTO) {



        Post savedPost = save(Post.builder()
                .user(userService.findById(postSaveDTO.userid()).orElseThrow(()-> new BlogAppException(USER_NOT_FOUND)))
                .title(postSaveDTO.title())
                .content(postSaveDTO.content())
                .category(categoryService.getCategories(postSaveDTO.categoryids()))
                .build());

        return PostMapper.INSTANCE.postToPostResponseDTO(savedPost);

    }


    public List<PostResponseDTO> findAllDTO() {
        List<PostResponseDTO> postResponseDTOList = new ArrayList<>();
        findAll().forEach(post -> {
            postResponseDTOList.add(PostMapper.INSTANCE.postToPostResponseDTO(post));
        });
        if(postResponseDTOList.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_POST_IN_THE_DATABASE);
        }
        return postResponseDTOList;
    }
}
