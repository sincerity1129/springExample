package com.example.kakaoexample.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.user.Users;
import com.example.kakaoexample.exception.OverRoomCountException;

import jakarta.persistence.EntityManager;

@SpringBootTest
class RoomServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("뿌리기 최초 인원 오류 테스트")
    void  test_00() throws Exception {
        // given
        int initCnt = 10;
        Users userA = Users.userCreate("X");
        userService.saveUser(userA);
        Users findUserA = userService.findById(userA.getId());
        Room roomA = Room.roomCreate(findUserA, "roomX");
        roomService.saveRoom(roomA);
        // when
        if(!roomA.isOverNumber(initCnt)){
            // then
            Assertions.assertThrows(Exception.class, () -> {
                throw new OverRoomCountException();
            });
        }
    }
}
