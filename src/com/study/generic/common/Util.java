package com.study.generic.common;

/**
 * Created by vvshinevv on 2018. 8. 18..
 */
public class Util {

    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();

        box.setT(t);
        return box;
    }
}
