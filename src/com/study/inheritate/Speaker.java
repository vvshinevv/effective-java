package com.study.inheritate;

/**
 * Created by vvshinevv on 2018. 8. 19..
 */
public class Speaker {

    private int volumeRate;

    public int getVolumeRate() {
        return volumeRate;
    }

    public void setVolumeRate(int volumeRate) {
        this.volumeRate = volumeRate;
    }

    public void showCurrentState() {
        System.out.println("볼륨 크기 :: " + getVolumeRate());
    }
}
