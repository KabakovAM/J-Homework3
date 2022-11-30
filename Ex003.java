package Homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex003 {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(numList);
        Integer max = Collections.max(numList);
        Integer min = Collections.min(numList);
        System.out.printf("Максимальное значение: %s%n", max);
        System.out.printf("Минимальное значение: %s", min);
    }
}
