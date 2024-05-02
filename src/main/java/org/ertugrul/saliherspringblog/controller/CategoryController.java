package org.ertugrul.saliherspringblog.controller;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.dto.requestDto.CategorySaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CategoryResponseDTO;
import org.ertugrul.saliherspringblog.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ertugrul.saliherspringblog.constant.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT+CATEGORY)
public class CategoryController {
    private final CategoryService categoryService;



    @PostMapping(SAVE)
    public ResponseEntity<CategoryResponseDTO> save(@RequestBody CategorySaveDTO categorySaveDTO){
        return ResponseEntity.ok(categoryService.saveDTO(categorySaveDTO));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<CategoryResponseDTO>> findAll(){
        return ResponseEntity.ok(categoryService.findAllDTO());
    }





}
