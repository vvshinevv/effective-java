package com.study.generic.common;

/**
 * Created by vvshinevv on 2018. 8. 18..
 */
public class BoxExample {

    public static void main(String[] args) {

        Box<String> box1 = new Box<>();
        box1.setT("Box1");

        Box<Integer> box2 = new Box<>();
        box2.setT(1);

        System.out.println("box1 : " + box1.getT() + " box2 : " + box2.getT());


        Box<Integer> box3 = Util.boxing(3);
        System.out.println(box3.getT());

    }
}
