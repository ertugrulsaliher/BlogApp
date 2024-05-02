package org.ertugrul.saliherspringblog.service;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseDTO;
import org.ertugrul.saliherspringblog.entity.Category;
import org.ertugrul.saliherspringblog.entity.Post;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.mapper.PostMapper;
import org.ertugrul.saliherspringblog.repository.PostRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.ertugrul.saliherspringblog.exception.ErrorType.*;

@Service

public class PostService extends ServiceManager<Post,Long> {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    public PostService(PostRepository postRepository, CategoryService categoryService) {
        super(postRepository);
        this.postRepository = postRepository;
        this.categoryService = categoryService;
    }

    public PostResponseDTO saveDTO(PostSaveDTO postSaveDTO) {
        postSaveDTO.categoryid().forEach(categoryId -> {
            if(!(checkCategory(categoryId))){
                throw new BlogAppException(CATEGORY_NOT_FOUND);
            }
        });


        Post savedPost = save(PostMapper.INSTANCE.postSaveDtoToPost(postSaveDTO));

        return PostMapper.INSTANCE.postToPostResponseDTO(savedPost);

    }
    private boolean checkCategory(Long id){
        Optional<Category> findedCategory = categoryService.findById(id);
        return findedCategory.isPresent();
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
