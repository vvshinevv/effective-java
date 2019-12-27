package effective.java.edition3.chapter06.example.code34_7;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operation34_7 {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private static final Map<String, Operation34_7> stringToEnum = Stream.of(values()).collect(toMap(Operation34_7::toString, e -> e));

    public static Optional<Operation34_7> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    private final String symbol;

    Operation34_7(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }
}
