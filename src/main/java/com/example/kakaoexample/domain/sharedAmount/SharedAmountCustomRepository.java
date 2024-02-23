package com.example.kakaoexample.domain.sharedAmount;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.kakaoexample.domain.share.Share;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SharedAmountCustomRepository {
    private final EntityManager em;

    public void saveSharedAmount(SharedAmount sharedAmount) {
        em.persist(sharedAmount);
    }

    // 2. 토큰 이름으로 분배건 조회 (테스트 용)
    public List<SharedAmount> findByToken(Share share) {
        return em.createQuery("select sa from SharedAmount sa where sa.share =:share ", SharedAmount.class)
                .setParameter("share", share).getResultList();
    }
}
