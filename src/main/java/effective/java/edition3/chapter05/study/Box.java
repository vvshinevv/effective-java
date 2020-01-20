package effective.java.edition3.chapter05.study;

public class Box<T> {

    protected T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }
}
