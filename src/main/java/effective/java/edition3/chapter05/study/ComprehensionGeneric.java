package effective.java.edition3.chapter05.study;

import java.util.ArrayList;
import java.util.List;

public class ComprehensionGeneric {

    public static <T extends Comparable<? super T>> void sort(List<T> list) {

    }
}
