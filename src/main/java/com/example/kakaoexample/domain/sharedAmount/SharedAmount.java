package com.example.kakaoexample.domain.sharedAmount;

import java.security.Timestamp;

import com.example.kakaoexample.domain.share.Share;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "SHAREDAMOUNT")
public class SharedAmount {
    @Id
    @GeneratedValue
    @Column(name = "x_shared_amt_id")
    private Long sharedAmtId; // 받기 PK

    @ManyToOne
    @JoinColumn(name = "x_share_id")
    private Share share; // Share table FK

    @Column(name = "x_seq")
    private Integer seq; // 토큰 당 분배 시퀀스

    @Column(name = "x_rcv_amt")
    private Long rcvAmt; // 분배 금액

    @Column(name = "x_rcv_id")
    private Long rcvId; // 분배 받은 사용자

    @Column(name = "x_rcv_time")
    private Timestamp rcvTime; // 분배 받은 시각

    protected SharedAmount() {
    }

    public static SharedAmount sharedAmountCreate(int seq, long rcvAmt){
        SharedAmount sharedAmount = new SharedAmount();
        sharedAmount.setSeq(seq);
        sharedAmount.setRcvAmt(rcvAmt);
        return sharedAmount;
    }
}