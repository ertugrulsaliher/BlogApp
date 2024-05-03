package org.ertugrul.saliherspringblog.service;

import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseDetailedDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseOnlyPostsDTO;
import org.ertugrul.saliherspringblog.entity.Post;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.mapper.PostMapper;
import org.ertugrul.saliherspringblog.repository.PostRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.ertugrul.saliherspringblog.exception.ErrorType.*;

@Service

public class PostService extends ServiceManager<Post,Long> {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final CommentService commentService;
    public PostService(PostRepository postRepository, CategoryService categoryService, UserService userService, CommentService commentService) {
        super(postRepository);
        this.postRepository = postRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.commentService = commentService;
    }

    public PostResponseDetailedDTO saveDTO(PostSaveDTO postSaveDTO) {

        Post savedPost = save(Post.builder()
                .user(userService.findById(postSaveDTO.userid()).orElseThrow(()-> new BlogAppException(USER_NOT_FOUND)))
                .title(postSaveDTO.title())
                .content(postSaveDTO.content())
                .category(categoryService.getCategories(postSaveDTO.categoryids()))
                .build());

        return PostMapper.INSTANCE.postToPostResponseDetailedDTO(savedPost);

    }


    public List<PostResponseOnlyPostsDTO> findAllDTO() {
        List<PostResponseOnlyPostsDTO> postResponseDetailedDTOList = new ArrayList<>();
        findAll().forEach(post -> {
            postResponseDetailedDTOList.add(PostMapper.INSTANCE.postToPostResponseOnlyPostsDTO(post));
        });
        if(postResponseDetailedDTOList.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_POST_IN_THE_DATABASE);
        }
        return postResponseDetailedDTOList;
    }

    public PostResponseDetailedDTO findByIdDetailed(Long postid) {
        Optional<Post> findedPost = findById(postid);
        if(findedPost.isEmpty()){
            throw new BlogAppException(POST_NOT_FOUND);
        }
        PostResponseDetailedDTO postResponseDetailedDTO = PostMapper.INSTANCE.postToPostResponseDetailedDTO(findedPost.get());
        postResponseDetailedDTO.comment().addAll(commentService.getPostsCommentList(postid));
        return postResponseDetailedDTO;

    }

    public List<PostResponseOnlyPostsDTO> findByUserid(Long userid) {
        List<PostResponseOnlyPostsDTO> postResponseDetailedDTOList = new ArrayList<>();
        userService.findById(userid).orElseThrow(()->new BlogAppException(USER_NOT_FOUND));
        List<Post> allByUserId = postRepository.findAllByUser_Id(userid);

        if(allByUserId.isEmpty()){
            throw new BlogAppException(USER_DID_NOT_POST);
        }
        allByUserId.forEach(post -> {
            postResponseDetailedDTOList.add(PostMapper.INSTANCE.postToPostResponseOnlyPostsDTO(post));
        });
        return postResponseDetailedDTOList;
    }

    public List<PostResponseOnlyPostsDTO> findByCategoryId(Long categoryid) {
        List<PostResponseOnlyPostsDTO> postResponseDetailedDTOList = new ArrayList<>();
        categoryService.findById(categoryid).orElseThrow(()->new BlogAppException(CATEGORY_NOT_FOUND));

        List<Post> allByCategoryId = postRepository.findAllByCategory_Id(categoryid);
        if(allByCategoryId.isEmpty()){
            throw new BlogAppException(CATEGORY_HAS_NOT_POST);
        }

        allByCategoryId.forEach(post -> {
            postResponseDetailedDTOList.add(PostMapper.INSTANCE.postToPostResponseOnlyPostsDTO(post));
        });
        return postResponseDetailedDTOList;
    }

    public List<PostResponseOnlyPostsDTO> findebycontent(String aramaKelimesi) {
        List<PostResponseOnlyPostsDTO> postResponseDetailedDTOList = new ArrayList<>();

        List<Post> allByContentContainsIgnoreCase = postRepository.findAllByContentContainsIgnoreCase(aramaKelimesi);
        if(allByContentContainsIgnoreCase.isEmpty()){
            throw new BlogAppException(NO_RESULT);
        }
        allByContentContainsIgnoreCase.forEach(post -> {
            postResponseDetailedDTOList.add(PostMapper.INSTANCE.postToPostResponseOnlyPostsDTO(post));
        });
        return postResponseDetailedDTOList;
    }

    public List<PostResponseOnlyPostsDTO> findAllOrderByPublishedAt() {
        List<PostResponseOnlyPostsDTO> postResponseDetailedDTOList = new ArrayList<>();

        List<Post> allOrOrderByCreateDateDesc = postRepository.findAllByOrderByBaseEntity_createdAtDesc();
        if(allOrOrderByCreateDateDesc.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_POST_IN_THE_DATABASE);
        }

        allOrOrderByCreateDateDesc.forEach(post -> {
            postResponseDetailedDTOList.add(PostMapper.INSTANCE.postToPostResponseOnlyPostsDTO(post));
        });
        return postResponseDetailedDTOList;

    }
}
