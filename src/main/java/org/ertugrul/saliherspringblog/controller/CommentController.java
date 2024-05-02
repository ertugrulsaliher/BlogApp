package org.ertugrul.saliherspringblog.controller;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.ertugrul.saliherspringblog.constant.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping
public class CommentController {
    private final CommentService commentService;
}
