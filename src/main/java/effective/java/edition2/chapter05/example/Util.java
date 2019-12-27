package effective.java.edition2.chapter05.example;

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
