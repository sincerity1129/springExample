package com.example.kakaoexample.domain.room;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RoomCustomRepository {
    final EntityManager em;
    
    public void saveRoom(Room room) {
        em.persist(room);
    }
}
