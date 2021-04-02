package effective.java.edition3.chapter06.example.code34_9;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PayrollDayTest {

    /**
     * 흠.. 분명히 admin_tmon_shared_area 개발했을때 enum 타입에 매개변수로 enum을 선언하고
     * 생성자로 초기화해주면 null 이 들어갔는데 여긴또 잘되네..
     * 다시 코드 봐야겠음 회사에서..
     * @param args
     */
    public static void main(String[] args) {
        List<PayrollDay> payrollDayArray = Arrays.stream(PayrollDay.values()).collect(toList());
        for (PayrollDay payrollDay : payrollDayArray) {
            System.out.println(payrollDay.getPayType());
            System.out.println(payrollDay.getEnumTest());
            System.out.println("=======================");
        }
    }
}
