package com.example.kakaoexample;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.user.Users;
import com.example.kakaoexample.domain.userRoom.UserRoom;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitDB {
    
    private final InitDBCreate initService;

    @PostConstruct
    public void init() {
        initService.createUserRoomData();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitDBCreate{
         private final EntityManager entityManager;

        public void createUserRoomData() {
            Users user1 = Users.userCreate("1");
            Users user4 = Users.userCreate("4");
            Users user7 = Users.userCreate("7");
            Users user10 = Users.userCreate("10");
            Users user13 = Users.userCreate("13");
            entityManager.persist(user1);
            entityManager.persist(user4);
            entityManager.persist(user7);
            entityManager.persist(user10);
            entityManager.persist(user13);

            Room roomA = Room.roomCreate(user1, "roomA");
            UserRoom userRoom1A =  UserRoom.userRoomCreate(user1, roomA);
            roomA.userRoomAdd(userRoom1A);
            Room roomB = Room.roomCreate(user4, "roomB");
            UserRoom userRoom4B =  UserRoom.userRoomCreate(user4, roomB);
            roomA.userRoomAdd(userRoom4B);
            Room roomC = Room.roomCreate(user1, "roomC");
            UserRoom userRoom1C =  UserRoom.userRoomCreate(user1, roomC);
            roomA.userRoomAdd(userRoom1C); 
            Room roomD = Room.roomCreate(user4, "roomD");
            UserRoom userRoom4D =  UserRoom.userRoomCreate(user4, roomD);
            roomA.userRoomAdd(userRoom4D);
            Room roomE = Room.roomCreate(user7, "roomE");
            UserRoom userRoom7E =  UserRoom.userRoomCreate(user4, roomE);
            roomA.userRoomAdd(userRoom7E);
            
            entityManager.persist(roomA); 
            entityManager.persist(roomB);
            entityManager.persist(roomC);
            entityManager.persist(roomD);
            entityManager.persist(roomE); 

            // roomA
            UserRoom userRoom4A =  UserRoom.userRoomCreate(user4, roomA);
            user4.userRoomAdd(userRoom4A);
            UserRoom userRoom7A =  UserRoom.userRoomCreate(user7, roomA);
            user7.userRoomAdd(userRoom7A);
            UserRoom userRoom10A =  UserRoom.userRoomCreate(user10, roomA);
            user10.userRoomAdd(userRoom10A); 
            UserRoom userRoom13A =  UserRoom.userRoomCreate(user13, roomA);
            user13.userRoomAdd(userRoom13A);
            entityManager.persist(userRoom4A);
            entityManager.persist(userRoom7A);
            entityManager.persist(userRoom10A);
            entityManager.persist(userRoom13A);
            // roomB
            UserRoom userRoom7B =  UserRoom.userRoomCreate(user7, roomB);
            user7.userRoomAdd(userRoom7B);
            entityManager.persist(userRoom7B);
            // roomC
            UserRoom userRoom7C =  UserRoom.userRoomCreate(user7, roomC);
            user7.userRoomAdd(userRoom7C);
            UserRoom userRoom10C =  UserRoom.userRoomCreate(user10, roomC);
            user10.userRoomAdd(userRoom10C);
            entityManager.persist(userRoom7C);
            entityManager.persist(userRoom10C);
            // roomD
            UserRoom userRoom7D =  UserRoom.userRoomCreate(user7, roomD);
            user7.userRoomAdd(userRoom7D);
            UserRoom userRoom10D =  UserRoom.userRoomCreate(user10, roomD);
            user10.userRoomAdd(userRoom10D);
            UserRoom userRoom13D =  UserRoom.userRoomCreate(user13, roomD);
            user13.userRoomAdd(userRoom13D);
            entityManager.persist(userRoom7D);
            entityManager.persist(userRoom10D);
            entityManager.persist(userRoom13D);
            // roomE
            UserRoom userRoom13E =  UserRoom.userRoomCreate(user13, roomE);
            user13.userRoomAdd(userRoom13E);
            entityManager.persist(userRoom13E);

            entityManager.persist(user4);
            entityManager.persist(user7);
            entityManager.persist(user10);
            entityManager.persist(user13);
        }
    }
}
