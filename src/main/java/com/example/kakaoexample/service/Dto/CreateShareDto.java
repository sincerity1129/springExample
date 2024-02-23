package com.example.kakaoexample.service.Dto;

import lombok.Data;

@Data
public class CreateShareDto {

    private final String newToken;

    public CreateShareDto(String newToken) {
        this.newToken = newToken;
    }
}