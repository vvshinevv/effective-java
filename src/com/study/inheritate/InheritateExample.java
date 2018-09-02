package com.study.inheritate;

/**
 * Created by vvshinevv on 2018. 8. 19..
 */
public class InheritateExample {

    public static void main(String[] args) {
        Speaker speaker = new BaseEnSpeaker();

        speaker.setVolumeRate(10);
        //speaker.setBaseRate(10); # BaseEnSpeaker 인스턴스의 메소드인데 compile 에러 발생
        speaker.showCurrentState();
    }
}
