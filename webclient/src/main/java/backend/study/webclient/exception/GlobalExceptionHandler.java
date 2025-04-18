package backend.study.webclient.exception;

import backend.study.webclient.dto.ErrorResponse;
import java.nio.file.AccessDeniedException;
import javax.security.sasl.AuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse.Res> handleException(Exception e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_500.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_500.getCode())
            .message(ErrorCode.DEFAULT_500.getMessage())
            .build();

        log.error("Exception : {}", e.getMessage());

        return ResponseEntity.internalServerError().body(res);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse.Res> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_400.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_400.getCode())
            .message(ErrorCode.DEFAULT_400.getMessage())
            .build();

        log.error("MethodArgumentNotValidException : {}", e.getMessage());

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse.Res> handleMethodArgumentTypeMismatchException(
        MethodArgumentTypeMismatchException e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_400.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_400.getCode())
            .message(ErrorCode.DEFAULT_400.getMessage())
            .build();

        log.error("MethodArgumentTypeMismatchException : {}", e.getMessage());

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse.Res> handleHttpMessageNotReadableException(
        HttpMessageNotReadableException e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_400.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_400.getCode())
            .message(ErrorCode.DEFAULT_400.getMessage())
            .build();

        log.error("HttpMessageNotReadableException : {}", e.getMessage());

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse.Res> handleConstraintViolationException(
        ConstraintViolationException e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_400.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_400.getCode())
            .message(ErrorCode.DEFAULT_400.getMessage())
            .build();

        log.error("ConstraintViolationException : {}", e.getMessage());

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<ErrorResponse.Res> handleAuthenticationException(
        AuthenticationException e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_401.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_401.getCode())
            .message(ErrorCode.DEFAULT_401.getMessage())
            .build();

        log.error("AuthenticationException : {}", e.getMessage());

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ErrorResponse.Res> handleAccessDeniedException(
        AccessDeniedException e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_403.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_403.getCode())
            .message(ErrorCode.DEFAULT_403.getMessage())
            .build();

        log.error("AccessDeniedException : {}", e.getMessage());

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorResponse.Res> handleNotFoundException(Exception e) {

        ErrorResponse.Res res = ErrorResponse.Res.builder()
            .httpStatus(ErrorCode.DEFAULT_404.getHttpStatus().value())
            .code(ErrorCode.DEFAULT_404.getCode())
            .message(ErrorCode.DEFAULT_404.getMessage())
            .build();

        log.error("NotFoundException : {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

}
