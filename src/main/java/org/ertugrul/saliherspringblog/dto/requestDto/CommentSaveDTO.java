package org.ertugrul.saliherspringblog.dto.requestDto;

public record CommentSaveDTO(String content,
                             Long userid,
                             Long postid) {
}
