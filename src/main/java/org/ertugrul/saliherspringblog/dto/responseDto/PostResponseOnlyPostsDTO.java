package org.ertugrul.saliherspringblog.dto.responseDto;

import java.util.List;

public record PostResponseOnlyPostsDTO(Long id,
                                       String title,
                                       String content,
                                       Long userid,
                                       String username,
                                       List<CategoryResponseDTO> category) {
}
