package com.qing.algorithms.leetcode.solution.easylevel;

/**
 * <b>7. 整数反转</b>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author guoqf
 * @date 2020/6/28 23:41
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x > 0) {
            //positive
            return reversePositive(x);
        } else if (x < 0) {
            //negative
            return reverseNegative(x);
        }
        return 0;
    }

    private int reversePositive(int posInt) {
        String s = Integer.toString(posInt);
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length > 0) {
            char temp;
            int front = 0;
            int back = length - 1 - front;
            while (back > front) {
                temp = chars[front];
                chars[front] = chars[back];
                chars[back] = temp;
                front++;
                back--;
            }

            String revStr = new String(chars);
            long l = Long.parseLong(revStr);
            if (l <= (long) Integer.MAX_VALUE) {
                return (int) l;
            }
        }
        return 0;
    }

    private int reverseNegative(int negInt) {
        String s = Integer.toString(negInt);
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length > 0) {
            char temp;
            int front = 1;
            int back = length - front;
            while (back > front) {
                temp = chars[front];
                chars[front] = chars[back];
                chars[back] = temp;
                front++;
                back--;
            }

            String revStr = new String(chars);

            long l = Long.parseLong(revStr);

            if (l >= (long) Integer.MIN_VALUE) {
                return (int) l;
            }
        }
        return 0;
    }




    private int reversePositiveInt(int posInt) {
        String s = Integer.toString(posInt);
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length > 0) {
            char temp;
            int front = 0;
            int back = length - 1 - front;
            while (back > front) {
                temp = chars[front];
                chars[front] = chars[back];
                chars[back] = temp;
                front++;
                back--;
            }

            String revStr = new String(chars);
            long l = Long.parseLong(revStr);
            if (l <= (long) Integer.MAX_VALUE) {
                return (int) l;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = -123;

        System.out.println((i / 1000));
        /*System.out.println("Source: " + i);
        int reverse = new ReverseInteger().reverse(i);
        System.out.println("Reverse: " + reverse);*/
    }
}
