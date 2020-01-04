package effective.java.edition3.chapter05.study;

public class BoxHandlerForOverloading {

    /**
     * Overloading Error
     * @param box
     */
//    public static void outBox(Box<? extends Toy> box) {
//        Toy toy = box.get();
//        System.out.println(toy.toString());
//    }

    /**
     * Overloading Error
     * @param box
     */
//    public static void outBox(Box<? extends Robot> box) {
//        Toy toy = box.get();
//        System.out.println(toy.toString());
//    }

    public static void inBox(Box<? super Toy> box, Toy toy) {
        box.set(toy);
    }

    public static void inBox(Box<? super Robot> box, Robot robot) {
        box.set(robot);
    }

    /**
     * Overloading for Generic
     * @param box
     */
    public static <T> void outBox(Box<? extends T> box) {
        T toy = box.get();
        System.out.println(toy.toString());
    }
}
