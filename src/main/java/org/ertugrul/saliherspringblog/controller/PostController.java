package org.ertugrul.saliherspringblog.controller;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.PostResponseDTO;
import org.ertugrul.saliherspringblog.repository.PostRepository;
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
    public ResponseEntity<PostResponseDTO> save(@RequestBody PostSaveDTO postSaveDTO){
        return ResponseEntity.ok(postService.saveDTO(postSaveDTO));
    }


    @GetMapping(FIND_ALL)
    public ResponseEntity<List<PostResponseDTO>> findAll(){
        return ResponseEntity.ok(postService.findAllDTO());
    }




}
