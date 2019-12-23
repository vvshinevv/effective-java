package effective.java.edition2.chapters.chapter05.example;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by vvshinevv on 2018. 8. 18..
 * 코드에서 ?를 일반적으로 와일드카드(wildcard)라고 부른다.
 * 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 구체적인 타입 대신에
 * 와일드 카드를 다음과 같이 세가지 형태로 사용할 수 있다.
 * <p>
 * 1. 제네릭 타입 <?> : Unbounded Wildcards (제한 없음)
 * -> 타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있다.
 * 2. 제네릭 타입 <? extends 상위타입> : Upper Bounded Wildcard (상위 클래스 제한)
 * -> 타입 파라미터를 대치하는 구체적인 타입으로 상위 타입이나 하위 타입만 올 수 있다.
 * 3. 제네릭 타입 <? super 하위타입> : Lower Bounded Wildcard (하위 클래스 제한)
 * -> 타입 파라미터를 대치하는 구체적인 타입으로 하위 타입이나 상위 타입이 올 수 있다.
 */
public class Course<T> {

    private String name;
    private List<T> students;

    public Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getStudents() {
        return students;
    }

    public void setStudents(List<T> students) {
        this.students = students;
    }

    public void add(T t) {

        if (students == null && students.size() == 0) {
            students = new ArrayList<>();
        }

        students.add(t);
    }
}
