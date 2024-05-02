package org.ertugrul.saliherspringblog.dto.requestDto;

import java.util.List;

public record PostSaveDTO(
        Long userid,
        String title,
        String content,
        List<Long> categoryids) {
}
