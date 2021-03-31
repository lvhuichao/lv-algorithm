package com.lv.algorithm;

import java.util.Random;

/**
 * @desc: 大数相加
 * @author: huichaolv@tencent.com
 * @create: 2021/3/31
 */
public class Sum {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int a = Math.abs(random.nextInt());
            int b = Math.abs(random.nextInt());
            String sum = sum(a + "", b + "");
            if (a + b == Long.parseLong(sum)) {
                System.out.println(sum);
                System.out.println(true);
            }
        }
    }

    private static String sum(String a, String b) {
        char[] chars = sum(new StringBuffer(a).reverse().toString().toCharArray(),
                new StringBuffer(b).reverse().toString().toCharArray());
        return new StringBuffer(new String(chars)).reverse().toString();
    }

    private static char[] sum(char[] a, char[] b) {
        int max = Math.max(a.length, b.length);
        char[] result = new char[max + 1];
        int up = 0;
        for (int i = 0; i < max; i++) {
            char m = i < a.length ? a[i] : '0';
            char n = i < b.length ? b[i] : '0';
            int sum = m + n - 2 * '0' + up;
            up = sum / 10;
            int current = sum % 10;
            result[i] = (char) (current + '0');
        }
        result[max] = (char) (up + '0');
        return result;
    }
}
