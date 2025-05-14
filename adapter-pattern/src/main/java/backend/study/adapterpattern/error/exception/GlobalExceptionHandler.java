package backend.study.adapterpattern.error.exception;

import backend.study.adapterpattern.error.cd.ErrorCode;
import backend.study.adapterpattern.error.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @ExceptionHandler(UnauthorizedTokenException.class)
    public ResponseEntity<ErrorResponseDto> handleUnauthorizedToken(
        UnauthorizedTokenException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.UNAUTHORIZED_TOKEN.getCode())
            .errorMessage(ErrorCode.UNAUTHORIZED_TOKEN.getMessage())
            .build();

        log.error("UnauthorizedTokenException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.UNAUTHORIZED_TOKEN.getHttpStatus());
    }

    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<ErrorResponseDto> handleExpiredToken(
        ExpiredTokenException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.EXPIRED_TOKEN.getCode())
            .errorMessage(ErrorCode.EXPIRED_TOKEN.getMessage())
            .build();

        log.error("ExpiredTokenException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.EXPIRED_TOKEN.getHttpStatus());
    }

    @ExceptionHandler(MalformedTokenException.class)
    public ResponseEntity<ErrorResponseDto> handleMalformedTokenException(
        MalformedTokenException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.MALFORMED_TOKEN.getCode())
            .errorMessage(ErrorCode.MALFORMED_TOKEN.getMessage())
            .build();

        log.error("MalformedTokenException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.MALFORMED_TOKEN.getHttpStatus());
    }

    @ExceptionHandler(InvalidSignatureException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidSignatureException(
        InvalidSignatureException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.INVALID_SIGN_TOKEN.getCode())
            .errorMessage(ErrorCode.INVALID_SIGN_TOKEN.getMessage())
            .build();

        log.error("InvalidSignatureException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.INVALID_SIGN_TOKEN.getHttpStatus());
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidTokenException(
        InvalidTokenException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.INVALID_TOKEN.getCode())
            .errorMessage(ErrorCode.INVALID_TOKEN.getMessage())
            .build();

        log.error("InvalidTokenException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.INVALID_TOKEN.getHttpStatus());
    }

    @ExceptionHandler(UnknownTokenException.class)
    public ResponseEntity<ErrorResponseDto> handleUnknownTokenException(
        UnknownTokenException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.UNKNOWN_TOKEN.getCode())
            .errorMessage(ErrorCode.UNKNOWN_TOKEN.getMessage())
            .build();

        log.error("UnknownTokenException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.UNKNOWN_TOKEN.getHttpStatus());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseDto> handleBadCredentialsException(
        BadCredentialsException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.BAD_CREDENTIAL.getCode())
            .errorMessage(ErrorCode.BAD_CREDENTIAL.getMessage())
            .build();

        log.error("BadCredentialsException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.BAD_CREDENTIAL.getHttpStatus());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUsernameNotFoundException(
        UsernameNotFoundException ex) {

        ErrorResponseDto res = ErrorResponseDto.builder()
            .errorCode(ErrorCode.NOT_FOUND_USER.getCode())
            .errorMessage(ErrorCode.NOT_FOUND_USER.getMessage())
            .build();

        log.error("UsernameNotFoundException : {}", ex.getMessage());

        return new ResponseEntity<>(res, ErrorCode.NOT_FOUND_USER.getHttpStatus());
    }
}
