package effective.java.edition3.chapter05;

public class GenericTest {

    public static void main(String[] args) {
        GenericClass<String> stringGenericClass = new GenericClass<>();
        stringGenericClass.set("i am boy");
        System.out.println(stringGenericClass.get());
    }

    static class GenericClass<T> {
        private T t;

        T get() {
            return this.t;
        }

        void set(T t) {
            this.t = t;
        }
    }

}
