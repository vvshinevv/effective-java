package effective.java.edition2.chapter05.example;

/**
 * Created by vvshinevv on 2018. 8. 18..
 */
public class Box<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
