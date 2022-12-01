package Homework3;

import java.util.List;
import java.util.ArrayList;

public class Ex001 {
    static List<List<Integer>> result;

    public static void main(String[] args) {
        String mainExp = "?00+?0=?30";
        mainExp = mainExp.replace(" ", "");
        char[] charExp = mainExp.toCharArray();
        List<Integer> indexExp = new ArrayList<>();
        for (int i = 0; i < charExp.length; i++) {
            if (charExp[i] == '?') {
                indexExp.add(i);
            }
        }
        List<List<Integer>> combExp = new ArrayList<>();
        combExp = combine(indexExp.size());
        int count = 0;
        for (int i = 0; i < combExp.size(); i++) {
            for (int j = 0; j < indexExp.size(); j++) {
                charExp[indexExp.get(j)] = Character.forDigit(combExp.get(i).get(j), 10);
            }
            String resExp = new String(charExp);
            String tempResExp = resExp.replace("+", "=");
            int antiZero = 0;
            for (int v = 1; v < tempResExp.length() - 2; v++) {
                if (tempResExp.charAt(0) == '0' && tempResExp.charAt(1) != '='
                        || tempResExp.charAt(v) == '=' && tempResExp.charAt(v + 1) == '0'
                                && tempResExp.charAt(v + 2) != '='
                        || tempResExp.charAt(v) == '='
                                && tempResExp.charAt(tempResExp.length() - 1) == '0'
                                && tempResExp.length() - v - 1 == 1) {
                    antiZero++;
                }
            }
            if (antiZero == 0) {
                String[] numExp = tempResExp.split("=");
                int q = Integer.parseInt(numExp[0]);
                int w = Integer.parseInt(numExp[1]);
                int e = Integer.parseInt(numExp[2]);
                if (q + w == e) {
                    System.out.printf("%s) %s%n", ++count, resExp);
                }
            }
        }
        if (count == 0) {
            System.out.println("Выражение не существует.");
        }
    }

    public static List<List<Integer>> combine(int k) {
        result = new ArrayList<>();
        helper(new ArrayList<>(), k);
        return result;
    }

    public static void helper(List<Integer> comb, int k) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            comb.add(i);
            helper(comb, k);
            comb.remove(comb.size() - 1);
        }
    }
}
