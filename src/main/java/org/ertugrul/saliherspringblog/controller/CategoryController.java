package org.ertugrul.saliherspringblog.controller;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.dto.requestDto.CategorySaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CategoryResponseDetailedDTO;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.exception.ErrorType;
import org.ertugrul.saliherspringblog.mapper.CategoryMapper;
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
    public ResponseEntity<CategoryResponseDetailedDTO> save(@RequestBody CategorySaveDTO categorySaveDTO){
        return ResponseEntity.ok(categoryService.saveDTO(categorySaveDTO));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<CategoryResponseDetailedDTO>> findAll(){
        return ResponseEntity.ok(categoryService.findAllDTO());
    }


    @GetMapping("/{categoryid}")
    public ResponseEntity<CategoryResponseDetailedDTO> findById(@PathVariable Long categoryid){
        return ResponseEntity.ok(CategoryMapper.INSTANCE.categoryToCategoryResponseDetailedDTO(categoryService.findById(categoryid).orElseThrow(()->new BlogAppException(ErrorType.CATEGORY_NOT_FOUND))));
    }




}
