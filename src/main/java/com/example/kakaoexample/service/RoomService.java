package com.example.kakaoexample.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.room.RoomCustomRepository;
import com.example.kakaoexample.domain.room.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomCustomRepository roomCustomRepository;
    private final RoomRepository roomRepository;


    // 1. 방 저장
    public long saveRoom(Room room) {
        roomCustomRepository.saveRoom(room);
        return room.getId();
    }

    // 2. 방 이름으로 찾기
    public Room findByName(String roomName) {
        Room room = roomRepository.findByRoomName(roomName);
        return room;
    }
}
