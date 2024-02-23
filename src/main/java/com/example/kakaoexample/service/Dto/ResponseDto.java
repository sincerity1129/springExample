package com.example.kakaoexample.service.Dto;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto {
    private String code;
    private String message;
    private Object body;
    
    public ResponseDto( Object object ) {
        this.code = "200";
        this.message = "정상 처리";
        this.body = object;
    }
}