package com.example.kakaoexample.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>{
    public Users findByUserName(String userName);
}
