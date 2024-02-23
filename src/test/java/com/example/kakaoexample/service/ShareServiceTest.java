package com.example.kakaoexample.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.share.Share;
import com.example.kakaoexample.domain.share.ShareCustomRepository;
import com.example.kakaoexample.domain.user.Users;
import com.example.kakaoexample.domain.userRoom.UserRoom;


@SpringBootTest
@Transactional
class ShareServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    ShareService shareService;
    @Autowired
    RoomService roomService;
    @Autowired
    ShareCustomRepository shareCustomRepository;

    @Test
    @DisplayName("토큰 유효성 확인")
       void test_01() throws Exception {
        Users userA = Users.userCreate("X");
        userService.saveUser(userA);
        Users findUserA = userService.findById(userA.getId());
        Room roomA = Room.roomCreate(userA, "roomX");
        UserRoom userRoomA = UserRoom.userRoomCreate(findUserA, roomA);
        roomA.userRoomAdd(userRoomA);
        roomService.saveRoom(roomA);
        String token = "XYZ";
        Share share = Share.createShare(token, findUserA, roomA, 100010L, 4);
        shareCustomRepository.shareSave(share);

        // when
        String newToken = "XYZ";
        Share findShare = shareService.findByToken(newToken);

        // then : 토큰이 이미 존재(true) 해야 한다.
        assertEquals(true, findShare!=null);

    }
}
