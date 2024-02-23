package com.example.kakaoexample.domain.share;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ShareCustomRepository {
    private final EntityManager entityManager;

    public void shareSave(Share share) {
        entityManager.persist(share);
    }
}
