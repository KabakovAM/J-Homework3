package Homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex002 {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> evenList = new ArrayList<>();
        System.out.println(numList);
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) % 2 == 0) {
                evenList.add(numList.get(i));
            }
        }
        numList.removeAll(evenList);
        System.out.println(numList);
    }
}
