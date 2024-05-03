package org.ertugrul.saliherspringblog.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.ertugrul.saliherspringblog.dto.requestDto.UserSaveDTO;
import org.ertugrul.saliherspringblog.dto.responseDto.UserResponseDTO;
import org.ertugrul.saliherspringblog.entity.User;
import org.ertugrul.saliherspringblog.exception.BlogAppException;
import org.ertugrul.saliherspringblog.exception.ErrorType;
import org.ertugrul.saliherspringblog.mapper.UserMapper;
import org.ertugrul.saliherspringblog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ertugrul.saliherspringblog.constant.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT+USER)
public class UserController {
    private final UserService userService;











    @PostMapping(SAVE)
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserSaveDTO userSaveDTO) {
        return ResponseEntity.ok(userService.register(userSaveDTO));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(userService.findAllDTO());
    }


    @GetMapping("/{userid}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long userid) {
        return ResponseEntity.ok(UserMapper.INSTANCE.UserToUserResponseDTO(userService.findById(userid).orElseThrow(()->new BlogAppException(ErrorType.USER_NOT_FOUND))));
    }



}
