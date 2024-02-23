package com.example.kakaoexample.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.room.RoomRepository;
import com.example.kakaoexample.domain.share.Share;
import com.example.kakaoexample.domain.share.ShareCustomRepository;
import com.example.kakaoexample.domain.share.ShareRepository;
import com.example.kakaoexample.domain.sharedAmount.SharedAmount;
import com.example.kakaoexample.domain.sharedAmount.SharedAmountCustomRepository;
import com.example.kakaoexample.domain.user.Users;
import com.example.kakaoexample.domain.user.UsersCustomRepository;
import com.example.kakaoexample.exception.NotActivationStatusException;
import com.example.kakaoexample.util.Utility;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ShareService {

    private final UsersCustomRepository usersCustomRepository;
    private final RoomRepository roomRepository;
    private final ShareRepository shareRepository;
    private final ShareCustomRepository shareCustomRepository;
    private final SharedAmountCustomRepository sharedAmountCustomRepository;

    public Share findByToken(String tokenName) {
        return shareRepository.findByToken(tokenName);
    }

    @Transactional
    public String saveShare(Long userId, String roomName, long initAmt, int initCnt) {
        Users user = usersCustomRepository.findById(userId);
        Room room = roomRepository.findByRoomName(roomName);
        
        if (user == null) {
            throw new NotActivationStatusException();
        }

         String newToken = Utility.createToken();
         
         List<Long> dividedList = Utility.dividedAmount(initAmt, initCnt);

         int seq = 1;
         for (Long dividedAmount : dividedList) {
            SharedAmount diSharedSharedAmount = SharedAmount.sharedAmountCreate(seq, dividedAmount);
                sharedAmountCustomRepository.saveSharedAmount(diSharedSharedAmount);
            }
            Share share = Share.createShare(newToken, user, room, initAmt, initCnt);
            shareCustomRepository.shareSave(share);
        return share.getToken();
    }    
}