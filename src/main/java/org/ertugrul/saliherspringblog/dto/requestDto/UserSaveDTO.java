package org.ertugrul.saliherspringblog.dto.requestDto;

public record UserSaveDTO(String name,
        String surname,
        String email,
        String password,
        String passwordConformation) {
}
