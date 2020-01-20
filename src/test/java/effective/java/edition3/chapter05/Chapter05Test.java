package effective.java.edition3.chapter05;

import effective.java.edition3.chapter05.study.Box;
import effective.java.edition3.chapter05.study.BoxHandler;
import effective.java.edition3.chapter05.study.Car;
import effective.java.edition3.chapter05.study.Computer;
import effective.java.edition3.chapter05.study.EComputer;
import effective.java.edition3.chapter05.study.Plastic;
import effective.java.edition3.chapter05.study.Toy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void studyTest3() {
        List<Computer> list = new ArrayList<>();
        list.add(new Computer(1));
        list.add(new Computer(2));
        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    public void studyTest4() {
        List<EComputer> list = new ArrayList<>();
        list.add(new EComputer(1));
        list.add(new EComputer(2));
        Collections.sort(list);
        System.out.println(list);
    }
}
