package org.ertugrul.saliherspringblog.controller;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.dto.requestDto.CommentSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CommentResponseDTO;
import org.ertugrul.saliherspringblog.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ertugrul.saliherspringblog.constant.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT+COMMENT)
public class CommentController {
    private final CommentService commentService;


    @PostMapping(SAVE)
    public ResponseEntity<CommentResponseDTO> save(@RequestBody CommentSaveDTO commentSaveDTO) {
        return ResponseEntity.ok(commentService.saveDTO(commentSaveDTO));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<CommentResponseDTO>> findAll() {
        return ResponseEntity.ok(commentService.findAllDTO());
    }




}
