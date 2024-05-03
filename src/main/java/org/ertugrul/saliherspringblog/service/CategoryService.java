package org.ertugrul.saliherspringblog.service;

import org.ertugrul.saliherspringblog.dto.requestDto.CategorySaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CategoryResponseDetailedDTO;
import org.ertugrul.saliherspringblog.entity.Category;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.mapper.CategoryMapper;
import org.ertugrul.saliherspringblog.repository.CategoryRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.ertugrul.saliherspringblog.exception.ErrorType.*;

@Service
public class CategoryService extends ServiceManager<Category,Long> {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDetailedDTO saveDTO(CategorySaveDTO categorySaveDTO) {
        if(categoryRepository.existsByNameIgnoreCase(categorySaveDTO.name())){
            throw new BlogAppException(CATEGORY_IS_ALREADY_EXIST);
        }

        Category savedCategory = save(CategoryMapper.INSTANCE.categorySaveDTOToCategory(categorySaveDTO));

        return CategoryMapper.INSTANCE.categoryToCategoryResponseDetailedDTO(savedCategory);

    }


    public List<CategoryResponseDetailedDTO> findAllDTO() {
        List<CategoryResponseDetailedDTO> categoryResponseDetailedDTOS = new ArrayList<>();

        findAll().forEach(category -> {
            categoryResponseDetailedDTOS.add(CategoryMapper.INSTANCE.categoryToCategoryResponseDetailedDTO(category));
        });
        if(categoryResponseDetailedDTOS.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_CATEGORY_IN_THE_DATABASE);
        }

        return categoryResponseDetailedDTOS;
    }

    public List<Category> getCategories(List<Long> categoryids) {
        List<Category> categories = new ArrayList<>();
        categoryids.forEach(categoryId -> {
            Optional<Category> findedCategory = findById(categoryId);
            if(!(findedCategory.isPresent())){
                throw new BlogAppException(CATEGORY_NOT_FOUND);
            }else{
                categories.add(findedCategory.get());
            }
        });
        return categories;

    }

    public List<CategoryResponseDetailedDTO> findByCategoryName(String categoryName) {
        List<CategoryResponseDetailedDTO> categoryResponseDetailedDTOS = new ArrayList<>();
        List<Category> allByOrderByNameAsc = categoryRepository.findByNameContainsIgnoreCaseOrderByNameAsc(categoryName);
        if(allByOrderByNameAsc.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_CATEGORY_IN_THE_DATABASE);
        }
        allByOrderByNameAsc.forEach(category -> {
            categoryResponseDetailedDTOS.add(CategoryMapper.INSTANCE.categoryToCategoryResponseDetailedDTO(category));
        });
        return categoryResponseDetailedDTOS;


    }
}
