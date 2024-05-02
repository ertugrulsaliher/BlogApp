package org.ertugrul.saliherspringblog.service;

import org.ertugrul.saliherspringblog.dto.requestDto.CategorySaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CategoryResponseDTO;
import org.ertugrul.saliherspringblog.entity.Category;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.mapper.CategoryMapper;
import org.ertugrul.saliherspringblog.repository.CategoryRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.ertugrul.saliherspringblog.exception.ErrorType.*;

@Service
public class CategoryService extends ServiceManager<Category,Long> {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDTO saveDTO(CategorySaveDTO categorySaveDTO) {
        if(categoryRepository.existsByNameIgnoreCase(categorySaveDTO.name())){
            throw new BlogAppException(CATEGORY_IS_ALREADY_EXIST);
        }

        Category savedCategory = save(CategoryMapper.INSTANCE.categorySaveDTOToCategory(categorySaveDTO));

        return CategoryMapper.INSTANCE.categoryToCategoryResponseDTO(savedCategory);

    }


    public List<CategoryResponseDTO> findAllDTO() {
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();

        findAll().forEach(category -> {
            categoryResponseDTOS.add(CategoryMapper.INSTANCE.categoryToCategoryResponseDTO(category));
        });
        if(categoryResponseDTOS.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_CATEGORY_IN_THE_DATABASE);
        }

        return categoryResponseDTOS;
    }
}
