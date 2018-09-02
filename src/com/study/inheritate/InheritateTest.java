package com.study.inheritate;

/**
 * Created by vvshinevv on 2018. 8. 19..
 */
public class InheritateTest {

    private class AAA {}
    private class BBB extends AAA {}
    private class CCC extends BBB {}

    AAA a1 = new BBB();
    AAA a2 = new CCC();
    BBB b1 = new CCC();


    CCC c1 = new CCC();
    AAA a3 = c1;
    BBB b2 = c1;


    AAA a4 = new CCC();
    // BBB b3 = a4;
    // CCC c2 = a4;
}
