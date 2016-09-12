package com.ekiselev.euler;

import java.util.*;
import java.util.stream.*;


/**
 * Created by ekiselev on 9/9/2016.
 */
public class Problem1 {

    private static class Solution {

        long solver(long N) {
            long n = N / 3;
            if (N % 3 == 0) {
                n--;
            }
            long three = 0;
            if (n > 0) {
                three = (6 + 3 * (n - 1)) * n / 2;
            }

            n = N / 15;
            if (N % 15 == 0) {
                n--;
            }
            long fithteen = 0;
            if (n > 0) {
                fithteen = (2 * 15 + 15 * (n - 1)) * n / 2;
            }

            n = N / 5;
            if (N % 5 == 0) {
                n--;
            }

            long five = 0;
            if (n > 0) {
                five = (2 * 5 + 5 * (n - 1)) * n / 2;
            }

            return three - fithteen + five;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextLong();
        Solution sol = new Solution();

        LongStream stream = Utils.longStream(sc);

        stream.limit(T)
                .map(sol::solver)
                .forEach(System.out::println);

    }
}

