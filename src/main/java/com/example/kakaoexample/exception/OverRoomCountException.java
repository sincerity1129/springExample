package com.example.kakaoexample.exception;

public class OverRoomCountException extends ShareException {
    public OverRoomCountException() {
        super("뿌릴 인원은 대화방 인원 보다 작거나 한 명 이상이어야 합니다.");
    }
}
