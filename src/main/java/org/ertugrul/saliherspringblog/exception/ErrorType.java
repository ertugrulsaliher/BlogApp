package org.ertugrul.movieapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    MOVIE_NOT_FOUND(5001,"Böyle bir Movie bulunmadı", HttpStatus.NOT_FOUND),
    USERNAME_OR_PASSWORD_WRONG(5002,"email ya da password hatalı", HttpStatus.NOT_FOUND),
    PASSWORD_MISMACTH(5003,"password uyuşmuyor", HttpStatus.NOT_FOUND);

    private Integer code;
    private String message;
    private HttpStatus httpStatus;
}
