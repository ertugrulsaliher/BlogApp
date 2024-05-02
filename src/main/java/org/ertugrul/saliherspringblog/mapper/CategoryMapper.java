package org.ertugrul.saliherspringblog.mapper;

import org.ertugrul.saliherspringblog.dto.requestDto.CategorySaveDTO;
import org.ertugrul.saliherspringblog.dto.requestDto.UserSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.CategoryResponseDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.UserResponseDTO;
import org.ertugrul.saliherspringblog.entity.Category;
import org.ertugrul.saliherspringblog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class );

    Category categorySaveDTOToCategory(CategorySaveDTO categorySaveDTO);
    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);








}
