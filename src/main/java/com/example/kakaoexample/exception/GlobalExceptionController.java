package com.example.kakaoexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kakaoexample.service.Dto.ErrorResponseDto;


// NOT_FOUND -> 404(토큰 미존재), INTERNAL_SERVER_ERROR -> 500(데이터 내부 잘못), BAD_REQUEST -> 400(파라미터 값 잘못)
@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(NotActivationStatusException.class)
    protected ResponseEntity<ErrorResponseDto> ErrorHandler(NotActivationStatusException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, errorResponse.getErrorStatus());
    }

    @ExceptionHandler(NotInTheRoomException.class)
    protected ResponseEntity<ErrorResponseDto> ErrorHandler(NotInTheRoomException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, errorResponse.getErrorStatus());
    }

    @ExceptionHandler(OverRoomCountException.class)
    protected ResponseEntity<ErrorResponseDto> ErrorHandler(OverRoomCountException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, errorResponse.getErrorStatus());
    }
}
