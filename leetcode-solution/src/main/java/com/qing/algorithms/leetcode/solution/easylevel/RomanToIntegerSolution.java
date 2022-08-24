package com.qing.algorithms.leetcode.solution.easylevel;

public class RomanToIntegerSolution {

    public int romanToInt(String s) {
        char[] romanArray = {'M', 'D', 'C', 'L', 'X', 'V'};
        int[] intAddition = {1000, 500, 100, 50, 10, 5};
        int[] intMinus = {100, 100, 10, 10, 1, 1};
        int total = 0;
        int fromIndex = 0;
        for (int i = 0; i < romanArray.length; i++) {
            char roman = romanArray[i];
            int index;
            while ((index = s.indexOf(roman, fromIndex)) >= 0) {
                //1000
                total += intAddition[i];

                if (index > fromIndex) {
                    total -= intMinus[i];
                }
                fromIndex = index + 1;
            }
        }

        total += s.length() - fromIndex;

        return total;
    }
}
