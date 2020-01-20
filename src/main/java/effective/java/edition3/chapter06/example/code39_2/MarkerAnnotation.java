package effective.java.edition3.chapter06.example.code39_2;

public class MarkerAnnotation {

    @MakerTest
    public static void m1() {

    }

    public static void m2() {

    }

    @MakerTest
    public static void m3() {
        throw new RuntimeException("실패");
    }

    public static void m4() {

    }

    @MakerTest
    public void m5() {

    }

    public void m6() {

    }

    @MakerTest
    public static void m7() {
        throw new RuntimeException("실패");
    }

    public static void m8() {

    }
}
