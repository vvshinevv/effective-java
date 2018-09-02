package com.study.inheritate;

/**
 * Created by vvshinevv on 2018. 8. 19..
 */
public class BaseEnSpeaker extends Speaker {

    private int baseRate;

    public int getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }

    public void showCurrentState() {
        System.out.println("베이스 크기 :: " + getBaseRate());
    }
}
