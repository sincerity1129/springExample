package com.example.kakaoexample.domain.share;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Long> {
    public Share findByToken(String tokenName);
}
