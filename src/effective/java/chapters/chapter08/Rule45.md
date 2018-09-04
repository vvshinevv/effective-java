### 규칙 45 지역 변수의 유효범위를 최소화하라
***

지역 변수의 유효범위를 최소화하면 가독성과 유지보수성이 좋아지고, 오류 발생 가능성도 줄어든다. **지역 변수의 유효범위를 최소화하는 가장 강력한 기법은, 처음으로 사용하는 곳에서 선언하는 것이다.**

**거의 모든** 지역 변수 선언에는 초기값이 포함되어야 한다. 변수를 초기화하기에 충분한 정보가 없다면, 그때까지는 선언을 미뤄야 한다. try - catch 의 경우 변수를 적절히 초기화할 수 없을 수도 있다.

**순환문을 잘 쓰면 변수의 유효범위를 최소화할 수 있다.**
```java
@Test
public void test_step_01() {

    for (Integer integer : integerList1) {
        System.out.println(integer + " ");
    }
}

@Test
public void test_step_02() {
    for (Iterator i = integerList1.iterator(); i.hasNext(); ) {
        System.out.println(i.next() + " ");
    }
}
```
for 문이나 for-each 문을 사용하면 순환문 변수(loop variable)라는 것을 선언할 수 있는데, 그 유효범위는 선언된 지역 안으로 제한된다. 따라서 while 문보다는 for 문을 쓰는 것이 좋다.

***'복사 - 붙여넣기' 의 버그를 조심해야 한다.***
```java
@Test
public void test_step_03() {
    // for 문이 while 문 보다 좋은 이유
    Iterator i1 = integerList1.iterator();
    while (i1.hasNext()) {
        System.out.println(i1.next() + " ");
    }
    // 복사 붙여넣기로 인한 실수를 유발할 수 있음
    Iterator i2 = integerList2.iterator();
    while (i1.hasNext()) {
        System.out.println(i1.next() + " ");
    }
}

@Test
public void test_step_04() {
    for (Iterator i1 = integerList1.iterator(); i1.hasNext(); ) {
        System.out.println(i1.next() + " ");
    }
    // 컴파일 조차 되지 않음!
    for (Iterator i2 = integerList2.iterator(); i2.hasNext(); ) {
        System.out.println(i2.next() + " ");
    }
}
```
while 문의 경우 '복사 - 붙여넣기' 의 버그를 조심해야한다. for 문이나 for-each 문의 경우는 '복사 - 붙여넣기' 의 버그가 발생할 가능성이 줄어 든다. for 문은 while 문보다 코드 길이가 짧아서 가독성이 좋다.

지역 변수의 유효범위를 최소화하는 마지막 전략은 **메서드의 크기를 줄이고 특정한 기능에 집중하라는 것**이다.
