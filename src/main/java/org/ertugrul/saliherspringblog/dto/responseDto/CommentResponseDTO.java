package org.ertugrul.saliherspringblog.dto.responseDto;

public record CommentResponseDTO(Long userid,
                                 String username,
                                 Long postid,
                                 String content) {
}
