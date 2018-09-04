### 규칙 48 정확한 답이 필요하다면 float 와 double 은 피하라
***

float 와 double 은 _이진 부동 소수점 연산_을 수행하는데, 이것은 넓은 범위의 값에 대해 정확도가 높은 근사치를 제공할 수 있도록 설계 되었다. 하지만 정확한 결과를 제공하지 않기 때문에 **정확한 결과가 필요한 곳에는 사용하면 안 된다.** 
```java
@Test
public void test_step_01() {
    // $1.03 이 있을 때 42센트를 사용했다. 남은 돈은?
    System.out.println(1.03 - 0.42); // 0.6100000000000001
}
```
**float 와 double 은 특히 돈과 관계된 계산에는 적합하지 않다!**

아래 문제를 보자!
> 주머니에 1달라가 있고 10센트, 20센트, 30센트, 40센트 ... 1달라의 가격이 붙은 사탕이 있다. 가장 싼 사탕부터 시작해서 차례로 더 비싼 사탕을 구입해 나갈 때, 얼마나 많은 사탕을 살 수 있을까? 그 결과 남은 돈은 얼마 일까? 아마 우리는 10센트, 20센트, 30센트, 40센트 4개의 사탕을 사고 남은 돈이 없다고 생각할 것이다.
```java
@Test
public void test_step_01_1() {
    double funds = 1.00;
    int itemsBought = 0;
    for (double price = 0.10; funds >= price; price += 0.10) {
        funds -= price;
        itemsBought++;
    }
    System.out.println(itemsBought + " items bought.");
    System.out.println("Change: $" + funds);
}
```

돈 계산은 double 대신 BigDecimal, int, long 을 사용한다는 원칙을 지켜야 한다.
하지만 BigDecimal 의 대안은 기본 산술연산 자료형 보다 사용이 불편하며, 느리다.
BigDecimal 의 대안보다 int 나 long 을 사용하는 것이 좋다.

결론은 정확한 답을 요구하는 문제를 풀 때는 float 나 double 을 쓰지 말라는 것이다.
소수점 이하 처리를 시스템에서 알아서 해 줬으면 하고, 기본 자료형보다 사용하기가 좀 불편해도 괜찮으며 성능이 떨어져도 상관없을 때는 BigDecimal 을 쓰라.
