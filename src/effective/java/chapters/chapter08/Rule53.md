### 규칙 53 리플렉션 대신 인터페이스를 이용하라
***

java.lang.reflect 의 핵심 리플렉션 기능을 이용하면 **메모리에 적재(load)된 클래스의 정보를 가져오는 프로그램을 작성할 수 있다.**<br>
Class 객체가 주어지면, 해당 객체가 나타내는 클래스의 생성자, 메서드, 필드 등을 나타내는 Constructor, Method Field 객체들을 가져올 수 있는데,<br>
이 객체들을 사용하면 클래스의 멤버 이름이나 필드 자료형, 메서드 시그니처 등의 정보들을 얻어낼 수 있다.
```java
@Test
public void test_step_01() {
    Class<?> clazz = null;
    try {
        clazz = Class.forName("com.effectivejava.chapter08.Member");
    } catch (ClassNotFoundException e) {
        System.err.println("Class not found.");
        e.printStackTrace();
    }
    Field[] fields = null;
    if (clazz != null) {
        fields = clazz.getDeclaredFields();
    }
}
```
게다가 Constructor, Method Field 객체를 이용하면, 거기 연결되어 있는 실제 생성자, 메서드, 필드들을 반영적으로(reflectively) 조작할 수 있다. 객체를 생성할 수도 있고, 메서드를 호출할 수도 있으며, 필드에 접근할 수도 있다.<br>
Constructor, Method Field 객체의 메서드를 통하면 된다. 예를 들어, Method.invoke를 이용하면 어떤 클래스의 어떤 객체에 정의된 어떤 메서드라도 호출할 수있다(물론 일반적인 보안 제약사항은 준수해야 한다).
또한 리플렉션을 이용하면, _소스 코드가 컴파일 될 당시에는 존재하지도 않았던 클래스를 이용할 수 있다._
```java
/** CglibAopProxy */
@Override
public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
  
  ...
  
  target = getTarget();
  if (target != null) {
    targetClass = target.getClass();
  }
  
  ...
  
  retVal = methodProxy.invoke(target, argsToUse);
  
  ...
  
}
```

하지만 이런 능력에는 대가가 따른다.
>1. 컴파일 시점에 자료형을 검사함으로써 얻을 수 있는 이점들을 포기해야 한다(예외 검사 포함).<br>2. 리플렉션 기능을 이용하는 코드는 가독성이 떨어진다.<br>3. 성능이 낮다. 리플렉션을 통한 메서드 호출 성능은 일반적인 메서드 호출에 비해 훨씬 낮다.
```java

@Test
public void test_step_02() {
    String[] step01_1 = { "java.util.TreeSet", "b", "c", "z", "a" };
    test_step_01_1(step01_1);
}

private void test_step_01_1(String[] args) {
    Class<?> clazz = null;
    try {
        clazz = Class.forName(args[0]);
    } catch (ClassNotFoundException e) {
        System.err.println("Class not found.");
        e.printStackTrace();
    }

    Set<String> set = null;

    try {
        set = (Set<String>) clazz.newInstance();
    } catch (IllegalAccessException e) {
        System.err.println("Class not accessible.");
        e.printStackTrace();
    } catch (InstantiationException e) {
        System.err.println("Class not instantiable.");
        e.printStackTrace();
    }

    set.addAll(Arrays.asList(args).subList(1, args.length));
    System.out.println(set);
}
```

**명심할 것은, 일반적인 프로그램은 프로그램 실행 중에 리플렉션을 통해 객체를 이용하려 하면 안된다는 것이다.**<br>
리플렉션이 필요한 복잡한 프로그램이 몇 가지 있긴 하다. 클래스 브라우저, 객체 검사도구, 코드 분석도구 등이 그 예다. <br>
또한 리플렉션은 스텁 컴파일러가 없는 원격 프로시저 호출(remote procedure call, RPC) 시스템을 구현하는 데 적당하다. <br>

**리플렉션을 아주 제한적으로만 사용하면 오버헤드는 피하면서도 리플렉션의 다양한 장점을 누릴 수 있다.**<br>
컴파일 시점에는 존재하지 않는 클래스를 이용해야 하는 프로그램 가운데 상당수는, 해당 클래스 객체를 참조하는 데 사용할 수 있는 인터페이스나 상위 클래스는 컴파일 시점에 이미 갖추고 있는 경우가 많다.<br>
그럴 때는, 객체 생성은 리플렉션으로 하고 객체 참조는 인터페이스나 상위 클래스를 통하면 된다.<br>
호출해야 하는 생성자가 아무런 인자도 받지 않을 때는 java.lang.reflect를 이용할 필요조차 없다. <br>
Class.newInstance 메서드를 호출하는 것으로 충분하다.

