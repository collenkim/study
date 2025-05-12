package backend.study.adapterpattern.error.exception;

import backend.study.adapterpattern.error.cd.ErrorCode;
import backend.study.adapterpattern.error.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 모든 예외를 처리하는 핸들러
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
            .errorMessage(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
            .build();

        log.error("Exception : {}", e.getMessage());

        return ResponseEntity.internalServerError().body(res);
    }

    // UnsupportedProviderException을 처리하는 핸들러
    @ExceptionHandler(value = UnsupportedProviderException.class)
    public ResponseEntity<ErrorResponseDto> handleUnsupportedProviderException(
        UnsupportedProviderException e) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.UNSUPPORTED_PROVIDER.getCode())
            .errorMessage(ErrorCode.UNSUPPORTED_PROVIDER.getMessage())
            .build();

        log.error("UnsupportedProviderException : {}", e.getMessage());

        return ResponseEntity.badRequest().body(res);
    }

}
