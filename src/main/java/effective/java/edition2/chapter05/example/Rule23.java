package effective.java.edition2.chapter05.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vvshinevv on 2018. 8. 19..
 */
public class Rule23 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        String s = stringList.get(0);
    }

    static void unsafeAdd(List list, Object object) {
        list.add(object);
    }

    static void safeAdd(List<Object> list, Object object) {
        list.add(object);
    }


}
