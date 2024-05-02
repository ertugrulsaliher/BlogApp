package org.ertugrul.saliherspringblog.mapper;

import org.ertugrul.saliherspringblog.dto.requestDto.UserSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.UserResponseDTO;
import org.ertugrul.saliherspringblog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class );

    User UserSaveDTOToUser(UserSaveDTO userSaveDTO);
    UserResponseDTO UserToUserResponseDTO(User user);








}
