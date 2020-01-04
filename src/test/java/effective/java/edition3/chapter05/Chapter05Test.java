package effective.java.edition3.chapter05;

import effective.java.edition3.chapter05.study.Box;
import effective.java.edition3.chapter05.study.BoxHandler;
import effective.java.edition3.chapter05.study.Car;
import effective.java.edition3.chapter05.study.Plastic;
import effective.java.edition3.chapter05.study.Toy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Chapter05Test {

    @Test
    public void studyTest1() {
        BoxHandler<Toy> toyBoxHandler = new BoxHandler<>();
        Box<Car> carBox = new Box<>();
        toyBoxHandler.outBox(carBox,  new Toy());
    }

    @Test
    public void studyTest2() {
        BoxHandler<Toy> toyBoxHandler = new BoxHandler<>();
        Box<Plastic> plasticBox = new Box<>();
        toyBoxHandler.inBox(plasticBox,  new Toy());
    }
}
