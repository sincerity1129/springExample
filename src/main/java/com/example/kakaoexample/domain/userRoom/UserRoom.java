package com.example.kakaoexample.domain.userRoom;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.user.Users;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "USERROOM")
public class UserRoom {
    @Id
    @GeneratedValue
    @Column(name="x_user_room_id")
    private Long userRoomId;
    
    @ManyToOne
    @JoinColumn(name="x_user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name="x_room_id")
    private Room room;

    protected UserRoom() {
    }

    public static UserRoom userRoomCreate(Users user, Room room) {
        UserRoom  userRoom = new UserRoom();
        userRoom.setUser(user);
        userRoom.setRoom(room);
        return userRoom;
    }
}
