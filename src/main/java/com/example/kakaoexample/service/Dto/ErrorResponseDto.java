package com.example.kakaoexample.service.Dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponseDto {
    private HttpStatus errorStatus;
    private int errorCode;
    private String errorMessage;

    public ErrorResponseDto( HttpStatus errStatus, int errCode, String errMsg) {
        this.errorStatus = errStatus;
        this.errorCode = errCode;
        this.errorMessage = errMsg;
    }
}
