### 규칙 49 객체화된 기본 자료형 대신 기본 자료형을 이용하라
***

자바의 자료형 시스템은 두 부분으로 나뉜다. 하나는 기본 자료형(int, double, boolean 등)이고 다른 하나는 String 과 List 등의 참조 자료형(reference type)이다. 모든 자료형에는 대응되는 참조 자료형이 있는데, 이를 **객체화된 기본 자료형**이라 부른다. **int, double, boolean 의 객체화된 기본 자료형은 각각 Integer, Double, Boolean** 이다.

기본 자료형과 객체화된 기본 자료형 사이에는 **세 가지 큰 차이점**이 있다.
>1.기본 자료형은 값만 가지지만 객체화된 기본 자료형은 값 외에도 _identity_를 가진다. 따라서 객체화된 기본 자료형 객체가 두 개 있을 때 그 값은 같더라도 identity 는 다를 수 있다.<br>2.기본 자료형에 저장되는 값은 전부 기능적으로 완전한 값이지만, 객체화된 자료형에 저장되는 값에는 그 이외에도 아무 기능도 없는 값, 즉 null 이 하나 있다.<br>3.기본 자료형은 시간적이나 공간 요구량 측면에서 일반적으로 객체 표현형보다 효율적이다.


아래 예시를 보자!
```java
@Test
public void test_step_01() {
    // Compare 메서드는 첫 인자의 값이 두 번째 인자의 값보다 작으면 음수, 같으면 0, 크면 양수를 반환한다.
    Comparator<Integer> naturalOrder = new Comparator<Integer>() {
        @Override
        public int compare(Integer first, Integer second) {
            return first < second ? -1 : (first == second ? 0 : 1);
        }
    };
    int result = naturalOrder.compare(new Integer(42), new Integer(42));
    Assert.isTrue(result == 1);
}
```
Integer 객체는 42라는 동일한 값을 나타내므로, 이 표현식이 반환하는 값은 0이어야 한다. 하지만 실제로 반환되는 값은 1이다. **==** 연산자는 객체 참조를 통해 **두 객체의 identity를 비교함**을 주의하자.


<br>
```java
@Test
public void test_step_02() {
    // 지역 int 변수를 추가하여 unboxing 을 통해 값을 비교하였다.
    Comparator<Integer> naturalOrder = new Comparator<Integer>() {
        @Override
        public int compare(Integer first, Integer second) {
            int f = first;
            int s = second;
            return f < s ? -1 : (f == s ? 0 : 1);
        }
    };
    int result = naturalOrder.compare(new Integer(42), new Integer(42));
    Assert.isTrue(result == 0);
}
```
지역 int 변수를 추가한다음에 이 두 변수를 이용해서 값을 비교 후 비교 결과 값을 반환하였다.


```java
static Integer i;
@Test(expected = NullPointerException.class)
public void test_step_03() {
    //
    if (i == 42) {
        System.out.println("Unbelievable");
    }
}
```
**(i == 42)를 계산할 때 NullPointException 을 발생시킨다.** 기본 자료형과 객체화된 기본 자료형을 한 연산 안에 엮어 놓으면 객체화된 기본 자료형은 자동으로 기본 자료형으로 반환한다. null 인 객체 참조를 기본 자료형으로 반환하려 시도하면 __NullPointException__ 을 발생시킨다.


```java
@Test
public void test_step_04() {
    Long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
        sum += i;
    }
    System.out.println(sum);
}
```
지역 변수 sum 을 long 이 아니라 Long 으로 선언했기 때문에 오류나 경고 없이 컴파일되는 프로그램이지만 변수가 계속해서 객체화와 비객체화를 반복하기 때문에 성능이 느려진다.

객체화된 기본 자료형은 컬렉션의 요소, 키, 값으로 사용할 때다. 컬렉션에는 기본 자료형을 넣을 수 없으므로 객체화된 자료형을 써야 한다.
