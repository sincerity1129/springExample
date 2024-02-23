package com.example.kakaoexample.domain.share;

import java.time.LocalDateTime;

import com.example.kakaoexample.domain.room.Room;
import com.example.kakaoexample.domain.user.Users;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "SHARE")
public class Share {
    @Id
    @GeneratedValue
    @Column(name="x_share_id", nullable = false)
    private Long shareId; // 뿌리기 PK

    @Column(name = "x_token", length = 255, unique = true)
    private String token; // 고유 토큰, unique 제약

    @ManyToOne
    @JoinColumn(name= "x_user_id")
    private Users user; // 뿌린 사용자
    @ManyToOne
    @JoinColumn(name= "x_room_id")
    private Room room; // 뿌려진 방

    @Column(name= "x_init_amt", nullable = false)
    private Long initAmt; // 최초 뿌린 금액

    @Column(name= "x_curr_amt", nullable = false)
    private Long currAmt; // 현재 남은 금액

    @Column(name= "x_init_cnt", nullable = false)
    private int initCnt; // 최초 뿌린 수

    @Column(name= "x_curr_cnt", nullable = false)
    private int currCnt; //현재 받은 사람
    
    @Column(name= "x_req_created_time", nullable = false)
    private LocalDateTime reqCreatedTime; // 뿌리기 생성 시간
        
    @Column(name= "x_req_ended_time ")
    private LocalDateTime reqEndedTime; // 뿌리기 생성 시간

    protected Share() {
    }
    
    public static Share createShare(String token, Users user, Room room, long initAmt, int initCnt) {
        Share share = new Share();
        share.setToken(token);
        share.setUser(user);
        share.setRoom(room);
        share.setInitAmt(initAmt);
        share.setCurrAmt(initAmt);
        share.setInitCnt(initCnt);
        share.setCurrCnt(0);
        share.setReqCreatedTime(LocalDateTime.now());
        return share;
    }
}
