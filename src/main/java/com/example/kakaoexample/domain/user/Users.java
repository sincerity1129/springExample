package com.example.kakaoexample.domain.user;

import java.time.LocalDateTime;

import com.example.kakaoexample.domain.userRoom.UserRoom;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Users {
    @Id
    @GeneratedValue
    @Column(name="x_user_id")
    private Long id;
    @Column(name="x_user_name")
    private String userName;

    @Column(name = "x_created_time", nullable = false)
    private LocalDateTime createdTime; // 사용자 생성 시각
    @Column(name = "x_ended_time")
    private LocalDateTime endedTime; // 사용자 삭제 시각
    
    protected Users() {
    }

    // 유저 생성
    public static Users userCreate(String userName) {
        Users user = new Users();
        user.setUserName(userName);
        user.setCreatedTime(LocalDateTime.now());
        return user;
    }

    public void userRoomAdd(UserRoom userRoom) {
        userRoom.setUser(this);
        userRoom.getRoom().setCurrInt(userRoom.getRoom().getCurrInt() + 1);
    }
}
