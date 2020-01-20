package effective.java.edition3.chapter06.example.code34_9;

public enum PayrollDay {

    MONDAY(PayType.WEEKEND, EnumTest.A),
    TUESDAY(PayType.WEEKEND, EnumTest.B),
    WEDNESDAY(PayType.WEEKEND, EnumTest.C),
    THURSDAY(PayType.WEEKEND, EnumTest.D),
    FRIDAY(PayType.WEEKEND, EnumTest.E),
    SATURDAY(PayType.WEEKEND, EnumTest.F),
    SUNDAY(PayType.WEEKDAY, EnumTest.G);

    private final PayType payType;
    private final EnumTest enumTest;

    PayrollDay(PayType payType, EnumTest enumTest) {
        this.payType = payType;
        this.enumTest = enumTest;
    }

    public PayType getPayType() {
        return this.payType;
    }

    public EnumTest getEnumTest() {
        return this.enumTest;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;

            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
