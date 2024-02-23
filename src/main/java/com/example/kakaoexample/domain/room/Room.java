package com.example.kakaoexample.domain.room;

import java.time.LocalDateTime;

import com.example.kakaoexample.domain.user.Users;
import com.example.kakaoexample.domain.userRoom.UserRoom;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue
    @Column(name="x_room_id")
    private Long id;
    @Column(name="x_room_name", unique = true)
    private String roomName;
    @Column(name = "x_created_user_id", nullable = false)
    private Long userId ; // 대화방 개설자
    @Column(name = "x_init_cnt", nullable = false)
    private int initCnt; // 대화방 개설시 최초 인원
    @Column(name = "x_curr_cnt", nullable = false)
    private int currInt; // 대화방 현재 남은 인원(default = x_init_cnt)
    @Column(name ="x_created_time", nullable = false)
    private LocalDateTime createdTime; // 대화방 개설 시각
    @Column(name ="x_ended_time")
    private LocalDateTime endedTime; // 대화방 종료 시각

    protected Room() {
    }
    // 방 생성
    public static Room roomCreate(Users userInfo, String roomName) {
        Room room = new Room();
        room.setRoomName(roomName);
        room.setUserId(userInfo.getId());
        room.setInitCnt(1);
        room.setCurrInt(1);
        room.setCreatedTime(LocalDateTime.now());
        return room;
    }
    public void userRoomAdd(UserRoom userRoom) {
        userRoom.setRoom(this);
    }

    public boolean isOverNumber(int initCnt) {
        if (this.currInt <= initCnt || initCnt < 1) {
            return false;
        }
        return true;
    }
}
