package com.example.kakaoexample.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakaoexample.service.ShareService;
import com.example.kakaoexample.service.Dto.CreateShareDto;
import com.example.kakaoexample.service.Dto.ResponseDto;
import com.example.kakaoexample.service.Dto.ShareApiDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ShareController {

    private final ShareService shareService;

    // header 방식으로 받기
    @PostMapping(value = "header")
    public ResponseDto createShareHeader(@RequestHeader(value = "X-USER-ID") @NotNull Long userId,
                                        @RequestHeader(value = "X-Room-ID") @NotBlank String roomName,
                                        @RequestParam(value = "initAmt") @NotNull long initAmt,
                                        @RequestParam(value = "initCnt") @NotNull int initCnt
    ) {
        String newToken = shareService.saveShare(userId, roomName, initAmt, initCnt);
        return new ResponseDto(new CreateShareDto(newToken));
    }

    // param 방식으로 보내기
    @PostMapping(value = "param")
    public ResponseEntity<ResponseDto> createShareParam(@RequestParam @NotNull Long userId,
                                                        @RequestParam @NotBlank String roomName,
                                                        @RequestParam @NotNull long initAmt,
                                                        @RequestParam @NotNull int initCnt
    ) {
        String newToken = shareService.saveShare(userId, roomName, initAmt, initCnt);
        return ResponseEntity.ok().body(new ResponseDto(new CreateShareDto(newToken)));
    }

    // json 방식으로 받기
    @PostMapping("json")
    public ResponseEntity<ResponseDto> createShareJson(@RequestBody ShareApiDto request) {
        String newToken = shareService.saveShare(request.getUserId(), request.getRoomName(), request.getInitAmt(), request.getInitCnt());
        return ResponseEntity.ok().body(new ResponseDto(new CreateShareDto(newToken)));
    }

}
