package com.qing.algorithms.leetcode.solution.easylevel;

/**
 * @author Guoqingfeng
 * @date 2020/7/11
 */
public class SqrtOfNum {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }



        int bitsOfX = 1;
        int tenPer = x / 10;
        while (tenPer > 0) {
            bitsOfX++;
            tenPer = x / 10;
        }

        int bitsOfSqrt = (bitsOfX & 1) == 1 ? (bitsOfX + 1) >>> 1 : bitsOfX >>> 1;
        int start = 1;
        for (int i = 0; i < bitsOfSqrt-1; i++) {
            start *= 10;
        }


        int end = start * 10;
        while (start < end) {
            int startMulti = start * start;
            long nextMulti = (start + 1) * (start + 1);
            if (startMulti <= x && nextMulti > x) {
                break;
            }

            int half = (end - start)/2 + start;

            long halfMulti = half * half;
            if (halfMulti == x) {
                return half;
            }
            if (halfMulti < x) {
                start = half;
            } else {
                end = half;
            }


        }
        return start;

    }

    public static void main(String[] args) {
        SqrtOfNum sqrtOfNum = new SqrtOfNum();
        int x = 10;
        long start = System.currentTimeMillis();
        int i = sqrtOfNum.mySqrt(x);
        System.out.println(i);
        System.out.println("Used :" + (System.currentTimeMillis() - start) + "ms");
    }
}
