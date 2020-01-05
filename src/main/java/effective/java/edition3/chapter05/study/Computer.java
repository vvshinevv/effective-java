package effective.java.edition3.chapter05.study;

public class Computer implements Comparable<Computer> {
    private int power;

    public Computer(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public int compareTo(Computer o) {
        return o.getPower() - this.power;
    }
}
