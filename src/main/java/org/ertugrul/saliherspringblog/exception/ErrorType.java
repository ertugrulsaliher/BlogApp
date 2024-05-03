package org.ertugrul.saliherspringblog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    USERNAME_OR_PASSWORD_WRONG(5002,"email ya da password hatalı", HttpStatus.NOT_FOUND),
    PASSWORD_MISMACTH(5003,"password uyuşmuyor", HttpStatus.NOT_FOUND),
    THERE_IS_NO_USER_IN_THE_DATABASE(5004,"Database'de hiç Kullanıcı yok",  HttpStatus.NOT_FOUND),
    CATEGORY_IS_ALREADY_EXIST(5005,"Kategori databesede zaten var", HttpStatus.CONFLICT),
    THERE_IS_NO_CATEGORY_IN_THE_DATABASE(5006,"DatabaseDe kategorti yok", HttpStatus.NOT_FOUND),
    CATEGORY_NOT_FOUND(5007,"Kategori yok", HttpStatus.NOT_FOUND),
    THERE_IS_NO_POST_IN_THE_DATABASE(5008,"Post yok", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND(5009,"User bulunamadı", HttpStatus.NOT_FOUND),
    POST_NOT_FOUND(5010,"Post yok", HttpStatus.NOT_FOUND),
    THERE_IS_NO_COMMENT_IN_THE_DATABASE(5011,"Comment yok", HttpStatus.NOT_FOUND),
    USER_DID_NOT_POST(5012,"userın postu yok", HttpStatus.NOT_FOUND),
    CATEGORY_HAS_NOT_POST(5013,"Categoride post yok", HttpStatus.NOT_FOUND),
    NO_RESULT(5014,"sonuç bulunamadı", HttpStatus.NOT_FOUND);

    private Integer code;
    private String message;
    private HttpStatus httpStatus;
}
