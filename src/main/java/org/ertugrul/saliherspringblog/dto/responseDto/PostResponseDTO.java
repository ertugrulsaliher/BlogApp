package org.ertugrul.saliherspringblog.dto.responseDto;

import java.util.List;

public record PostResponseDTO(
        Long id,
        String title,
        String content,
        Long userId,
        List<CategoryResponseDTO> categories //TODO Comment dto list de eklenecek

 ) {
}
