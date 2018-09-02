package effective.java.chapters.chapter04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vvshinevv on 2018. 8. 19..
 */
public class Rule23 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        safeAdd(stringList, new Integer(42));
        String s = stringList.get(0);
    }

    static void unsafeAdd(List list, Object object) {
        list.add(object);
    }

    static void safeAdd(List<Object> list, Object object) {
        list.add(object);
    }


}
