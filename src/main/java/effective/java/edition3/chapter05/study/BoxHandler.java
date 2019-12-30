package effective.java.edition3.chapter05.study;

public class BoxHandler<T> {

    public void outBox(Box<? extends T> box, T t) {
        T temp = box.get();
        //box.set(t); // 에러
    }

    public void inBox(Box<? super T> box, T t) {
        //T temp = box.get(); // 에러
        box.set(t);
    }
}
