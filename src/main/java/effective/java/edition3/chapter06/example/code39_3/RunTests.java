package effective.java.edition3.chapter06.example.code39_3;

import effective.java.edition3.chapter06.example.code39_2.MakerTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        /**
         * static 변수를 붙이면 잘못 사용된 테스트로 먹히는 이유?
         * 아마 어노테이션의 정적? 영역을 보면되지 않을까란 생각이 듬
         *
         * 근데 스터디하다가 인스턴스를 생성하지 않아서 그런것 같다는 뇌피셜이 나옴
         * 한번 테스트해봐야 함
         *
         * testClass.newInstance()
         */

        Class<?> testClass = Class.forName(args[0]);

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MakerTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    System.out.println(method + " 실패: " + throwable);
                    System.out.println("==========================");
                } catch (Exception e) {
                    System.out.println("잘못 사용한 테스트: " + method);
                    System.out.println("==========================");
                    throw e;

                }
            }
        }
        System.out.println();
        System.out.println("==========================");
        System.out.println("성공: " + passed);
        System.out.println("실패: " + (tests - passed));
        System.out.println("==========================");
    }
}
