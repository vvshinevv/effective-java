### 규칙 50 다른 자료형이 적절하다면 문자열 사용은 피하라
***

문자열은 텍스트 표현과 처리에 걸맞도록 설계되었다. 이번 절에서는 문자열로 해서는 안 되는 일들을 짚어본다.

**문자열은 값 자료형(value type)을 대신하기에는 부족하다. 데이터가 파일이나 네트워크나 키보드를 통해서 들어올 때는 보통 문자열 형태다.** <br>
그러니 그대로 두려는 경향이 있다. 하지만 데이터가 텍스트 형태일 때나 그렇게 하는 것이 좋다. 숫자라면 int, float, BigInteger 같은 수 자료형으로 변환해야 한다. 적당한 자료형이 없다면 새로 만들어야 한다.

**문자열은 enum 자료형을 대신하기에는 부족하다.** <br>
enum 은 문자열보다 훨씬 좋은 열거 자료형 상수들을 만들어 낸다.(규칙 30)

**문자열은 혼합 자료형을 대신하기엔 부족하다.**<br>
```String compoundKey = className + “#” + i.next();``` 이런 접근법에는 많은 문제가 있다. 필드 구분자로 사용한 문자가 필드 안에 들어가버리면 문제가 생긴다. 게다가 각 필드를 사용하려고 하면 문자열을 파싱해야 하는데, **느릴 뿐더러 멍청하고 오류 발생 가능성도 높은 과정**이다. **equal, toString, compareTo 메서드 같은 것도 제공**할 수 없다. 혼합 자료형을 표현할 클래스를 만트는 편이 낫다. 이런 클래스는 종종 private static 멤버 클래스로 선언된다.

**문자열은 권한(capability)을 표현하기엔 부족하다.**
때로 문자열을 사용해서 접근 권한을 표현하는 경우가 있다. 스레드 지역 변수 기능을 설계하는 경우를 예로 들어 살펴보자. 스레드마다 다른 변수를 제공하는 기능이다.<br> 
```java
/**
 * 쓰레드 지역 변수 기능
 * <p>
 * 클라이언트가 제공한 문자열 키로 스레드 지역 변수를 식별하도록 하는 설계를 보자. 아래 설계는 두가지 문제가 있다.
 * 1. 문자열이 스레드 지역 변수의 전역적인 이름 공간이라는 것이다.
 * ㄴ 이 접근법으로는 클라이언트가 제공하는 문자열 키의 유일성이 보장되어야 한다.
 * ㄴ 만일 두 클라이언트가 공교롭게도 같은 지역 변수명을 사용한다면 동일한 변수를 공유하게 되어 오류를 발생한다.
 * <p>
 * 2. 보안 문제도 있다.
 * ㄴ 악의적인 클라이언트가 의도적으로 다른 클라이언트와 같은 문자열을 사용하면,
 * ㄴ 다른 클라이언트의 데이터에 접근할 수 있게 된다.
 */
public class ThreadLocal01 {
    private ThreadLocal01() {
    }
    public void set(String key, Object value) {
    }
    public Object get(String key) {
        return null;
    }
}

/**
 * 위 2가지 문제를 해결하긴 했지만 개선의 여지가 있다.
 * <p>
 * '정적인 메서드들은 사실 더 이상 필요 없다. 키의 객체 메서드로 만들 수 있다.
 * 그렇게 하고나면 키는 더 이상 스레드 지역 변수의 키가 아니라, 그것 자체가 스레드 지역 변수가 된다.' -> ??
 */
public class ThreadLocal02 {
    private ThreadLocal02() {
    }
    public Key getKey() {
        return new Key();
    }
    public void set(Key key, Object value) {
    }
    public Object get(Key key) {
        return null;
    }
    class Key {
        Key() {
        }
    }
}

/**
 * 이후 Generic 으로 변경해서 사용한다.
 */
public class ThreadLocal03 {
    public ThreadLocal03() {
    }
    public void set(Object value) {
    }
    public Object get() {
        return null;
    }
}

public final class ThreadLocal04<T> {
    public ThreadLocal04() {
    }
    public void set(T value) {
    }
    public T get() {
        return null;
    }
}
```
