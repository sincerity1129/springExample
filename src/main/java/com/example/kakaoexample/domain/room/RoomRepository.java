package com.example.kakaoexample.domain.room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findByRoomName(String roomName);
}