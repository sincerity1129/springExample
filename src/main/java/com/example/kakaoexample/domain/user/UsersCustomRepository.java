package com.example.kakaoexample.domain.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.userRoom.UserRoom;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UsersCustomRepository {
    private final EntityManager em;

 public void saveUser(Users user) {
        em.persist(user);
    }

    // 2. 사용자 ID로 찾기
    public Users findById(Long userId) {
        return em.find(Users.class, userId);
    }

    // 3. 사용자가 특정방에 존재하는지 확인 (true : 해당 방에 있음 , false : 해당 방에 없음)
    public boolean isInRoom(Users user, Room room) {
        List<UserRoom> userRoomList = em.createQuery(" select ur from UserRoom ur where ur.user =:user and ur.room =:room", UserRoom.class)
                .setParameter("user", user).setParameter("room",room).getResultList();
        if(userRoomList.size()>0){
            return true;
        }
        return false;
    }
}
