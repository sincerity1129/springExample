package com.example.kakaoexample.service.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShareApiDto {
        @NotNull
        private final Long userId;
        @NotBlank
        private final String roomName;
        @NotNull
        private final long initAmt;
        @NotNull
        private final int initCnt;
}
