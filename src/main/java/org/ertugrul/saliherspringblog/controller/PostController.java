package org.ertugrul.saliherspringblog.controller;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseDetailedDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseOnlyPostsDTO;
import org.ertugrul.saliherspringblog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ertugrul.saliherspringblog.constant.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT+POST)
public class PostController {
    private final PostService postService;











    @PostMapping(SAVE)
    public ResponseEntity<PostResponseDetailedDTO> save(@RequestBody PostSaveDTO postSaveDTO){
        return ResponseEntity.ok(postService.saveDTO(postSaveDTO));
    }


    @GetMapping(FIND_ALL)
    public ResponseEntity<List<PostResponseOnlyPostsDTO>> findAll(){
        return ResponseEntity.ok(postService.findAllDTO());
    }

    @GetMapping("/{postid}")
    public ResponseEntity<PostResponseDetailedDTO> findById(@PathVariable Long postid){
        return ResponseEntity.ok(postService.findByIdDetailed(postid));
    }

    @GetMapping(USER+"/{userid}")
    public ResponseEntity<List<PostResponseOnlyPostsDTO>> findByUserid(@PathVariable Long userid){
        return ResponseEntity.ok(postService.findByUserid(userid));
    }
    @GetMapping(CATEGORY+"/{categoryid}")
    public ResponseEntity<List<PostResponseOnlyPostsDTO>> findByCategoryid(@PathVariable Long categoryid){
        return ResponseEntity.ok(postService.findByCategoryId(categoryid));
    }

    @GetMapping("/")
    public ResponseEntity<List<PostResponseOnlyPostsDTO>> findBycontent(@RequestParam("search") String aramaKelimesi){
        return ResponseEntity.ok(postService.findebycontent(aramaKelimesi));
    }


}
