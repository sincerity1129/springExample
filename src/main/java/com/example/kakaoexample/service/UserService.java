package com.example.kakaoexample.service;

import org.springframework.stereotype.Service;

import com.example.kakaoexample.domain.user.UsersRepository;
import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.user.Users;
import com.example.kakaoexample.domain.user.UsersCustomRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository userRepository;
    private final UsersCustomRepository userCustomRepository;

    // 1. 사용자 저장
    public void saveUser(Users user) {
        userCustomRepository.saveUser(user);
    }

    // 2. 사용자 찾기
    public Users findById(Long userId) {
        return userCustomRepository.findById(userId);
    }

    // 3. 사용자 이름으로 찾기
    public Users findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    // 4. 사용자가 특정방에 존재하는지 확인 (true : 해당 방에 있음 , false : 해당 방에 없음)
    public boolean isInRoom(Users user, Room room) {
        return userCustomRepository.isInRoom(user, room);
    }

}