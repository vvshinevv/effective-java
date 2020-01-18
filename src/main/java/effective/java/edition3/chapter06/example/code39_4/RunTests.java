package effective.java.edition3.chapter06.example.code39_4;

import effective.java.edition3.chapter06.example.code39_2.MakerTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName(args[0]);
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음\n", method);
                    System.out.println("==========================");
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    Class<? extends Throwable> executeType = method.getAnnotation(ExceptionTest.class).value();

                    if (executeType.isInstance(throwable)) {
                        passed++;
                    } else {
                        System.out.println(method + " 실패: " + throwable);
                        System.out.println("==========================");
                    }


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
