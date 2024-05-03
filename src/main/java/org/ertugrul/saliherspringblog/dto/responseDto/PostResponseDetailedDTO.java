package org.ertugrul.saliherspringblog.dto.responseDto;

import java.util.ArrayList;
import java.util.List;
public record PostResponseDetailedDTO(
        Long id,
        String title,
        String content,
        Long userid,
        String username,
        List<CategoryResponseDTO> category,
        List<CommentResponseDTO> comment
 ) {
 public PostResponseDetailedDTO {
  if (comment == null) {
   comment = new ArrayList<>();
  }
 }
}
