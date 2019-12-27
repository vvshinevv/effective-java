package effective.java.edition3.chapter06;

import effective.java.edition3.chapter06.example.code34_1.Code34_1;
import effective.java.edition3.chapter06.example.code34_2.Apple;
import effective.java.edition3.chapter06.example.code34_6.Operation34_6;
import effective.java.edition3.chapter06.example.code34_7.Operation34_7;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class Chapter06Test {

    @Test
    public void code34_1Test() {
        boolean isTrue = Code34_1.APPLE_FUJI == Code34_1.ORANGE_NAVEL;

        System.out.println(Code34_1.APPLE_FUJI);
        System.out.println(Code34_1.ORANGE_NAVEL);

        assertThat(isTrue, is(true));
    }

    @Test
    public void code34_2Test() {
        boolean isTrue = Apple.FUJI == Apple.GRANNY_SMITH;

        System.out.println(Apple.FUJI);
        System.out.println(Apple.GRANNY_SMITH);

        assertThat(isTrue, is(false));
    }

    @Test
    public void code34_6Test() {
        double x = 2.000000;
        double y = 4.000000;

        for (Operation34_6 operation : Operation34_6.values()) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }
    }

    @Test
    public void code34_7Test() {
        System.out.println(Operation34_7.fromString("+"));
    }

    @Test
    public void test() {
        System.out.println(2 << 2);
    }
}
