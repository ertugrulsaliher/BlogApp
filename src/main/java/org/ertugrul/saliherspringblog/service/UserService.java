package org.ertugrul.saliherspringblog.service;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.dto.requestDto.UserSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.UserResponseDTO;
import org.ertugrul.saliherspringblog.entity.User;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.mapper.UserMapper;
import org.ertugrul.saliherspringblog.repository.UserRepository;
import org.ertugrul.saliherspringblog.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.ertugrul.saliherspringblog.exception.ErrorType.*;

@Service

public class UserService extends ServiceManager<User,Long> {
    private final UserRepository userRepository;

    public UserService( UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public UserResponseDTO register(UserSaveDTO userSaveDTO) {
        if(!(checkPassword(userSaveDTO.password(), userSaveDTO.passwordConformation()))){
            throw new BlogAppException(PASSWORD_MISMACTH);
        }

        User savedUser = save(UserMapper.INSTANCE.UserSaveDTOToUser(userSaveDTO));

        return UserMapper.INSTANCE.UserToUserResponseDTO(savedUser);


    }
    private boolean checkPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


    public List<UserResponseDTO> findAllDTO() {
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        findAll().forEach(user -> {
            userResponseDTOS.add(UserMapper.INSTANCE.UserToUserResponseDTO(user));
        });
        if(userResponseDTOS.isEmpty()){
            throw new BlogAppException(THERE_IS_NO_USER_IN_THE_DATABASE);
        }
        return userResponseDTOS;
    }
}
