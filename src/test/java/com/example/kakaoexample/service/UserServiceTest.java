package com.example.kakaoexample.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.user.Users;
import com.example.kakaoexample.domain.userRoom.UserRoom;
import com.example.kakaoexample.exception.NotInTheRoomException;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;

    @Test
    @DisplayName("사용자가 대화방에 있는지 확인")
    //@Rollback(false)
    void test_00() throws Exception {
        // given
        Users userA = Users.userCreate("F");
        userService.saveUser(userA);
        Users findUserA = userService.findById(userA.getId());
        Room roomA = Room.roomCreate(findUserA, "roomF");
        UserRoom userRoomA = UserRoom.userRoomCreate(userA, roomA);
        roomA.userRoomAdd(userRoomA);
        roomService.saveRoom(roomA);

        Users userB = Users.userCreate("G");
        userService.saveUser(userB);
        Users findUserB = userService.findById(userB.getId());
        Room roomB = Room.roomCreate(findUserB, "roomG");
        UserRoom userRoomB = UserRoom.userRoomCreate(userB, roomB);
        roomB.userRoomAdd(userRoomB);
        roomService.saveRoom(roomB);

        // when : userA는 roomB에 속하지 않는다.
        if (!userService.isInRoom(findUserA, roomB)) {
            // then
            Assertions.assertThrows(Exception.class, () -> {
                throw new NotInTheRoomException();
            });
        }
    }
}
