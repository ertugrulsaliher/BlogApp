package org.ertugrul.saliherspringblog.exception;
//Tüm Controller sınıfları için merkezi bir şekidle hata yönetimni sağlayacaktır.



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BlogAppException.class)
    public ResponseEntity<ErrorMessage> handleDemoExeption(BlogAppException demoExeption) {
        ErrorType errorType = demoExeption.getErrorType();

        return new ResponseEntity(createErrorMesseahe(demoExeption),errorType.getHttpStatus());
    }

    private ErrorMessage createErrorMesseahe( BlogAppException demoExeption) {
        return ErrorMessage.builder().code(demoExeption.getErrorType().getCode()).message(demoExeption.getMessage()).build();
    }


    @ExceptionHandler(RuntimeException.class) //runtimeException hata yakalayıcı metod olduğunu beklirttik.
    public ResponseEntity<String> handleException(RuntimeException runtimeException) {
        System.err.println(runtimeException.getMessage());
        return ResponseEntity.badRequest().body("!!!!!!!!!!!!!uygulamada runtime eceptipn oluştu !!!!!!!!!!!!!!!");
    }



}
