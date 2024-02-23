package com.example.kakaoexample.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class Utility {
    public static String createToken() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static List<Long> dividedAmount(Long initAmt, int initCnt) {
        long leftMoney = initAmt;
        int leftCnt = initCnt+1;
        long minValue = 0;
        long maxValue = initAmt / initCnt * 2;

        List<Long> dividedList = new ArrayList<>();
        for (int i = 0; i < initCnt - 1; i++) {
            int currInt = (int) (Math.random() * leftCnt) + 1;
            long dividedMoney = Math.max(minValue, Math.min(maxValue, leftMoney / currInt));
            dividedList.add(dividedMoney);
            leftMoney -= dividedMoney;
        }
        dividedList.add(leftMoney);
        return dividedList;
    }
}
