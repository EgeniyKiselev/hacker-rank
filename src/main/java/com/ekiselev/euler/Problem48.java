package com.ekiselev.euler;

import com.google.common.base.Stopwatch;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by ekiselev on 9/16/2016.
 */
public class Problem48 {
    private static long TEN = 10_000_000_000L;
    private static long HALF_LONG = Long.MAX_VALUE / 2;
    private static BigInteger TEN_B = BigInteger.valueOf(TEN);
    private static TreeMap<Long, Long> pre_calc = new TreeMap<>();

    static {
        pre_calc.put(1L, 0L);
        pre_calc.put(850000L, 9319932500L);
        pre_calc.put(950000L, 8658352500L);
        pre_calc.put(1050000L, 9996772500L);
        pre_calc.put(1150000L, 3335192500L);
        pre_calc.put(1250000L, 8673612500L);
        pre_calc.put(1350000L, 6012032500L);
        pre_calc.put(1450000L, 5350452500L);
        pre_calc.put(1550000L, 6688872500L);
        pre_calc.put(1650000L, 27292500L);
        pre_calc.put(1750000L, 5365712500L);
        pre_calc.put(100000L, 3031782500L);
        pre_calc.put(200000L, 7370202500L);
        pre_calc.put(300000L, 3708622500L);
        pre_calc.put(400000L, 2047042500L);
        pre_calc.put(500000L, 2385462500L);
        pre_calc.put(600000L, 4723882500L);
        pre_calc.put(700000L, 9062302500L);
        pre_calc.put(800000L, 5400722500L);
        pre_calc.put(900000L, 3739142500L);
        pre_calc.put(1000000L, 4077562500L);
        pre_calc.put(1100000L, 6415982500L);
        pre_calc.put(1200000L, 754402500L);
        pre_calc.put(1300000L, 7092822500L);
        pre_calc.put(1400000L, 5431242500L);
        pre_calc.put(1500000L, 5769662500L);
        pre_calc.put(1600000L, 8108082500L);
        pre_calc.put(1700000L, 2446502500L);
        pre_calc.put(1800000L, 8784922500L);
        pre_calc.put(1900000L, 7123342500L);
        pre_calc.put(2000000L, 7461762500L);
    }

    private static class Solution {
        Map<Long, Long> cache = new HashMap<>(5000);

        public Solution() {
            for (long l = 15; l < 5135; l += 10) {
                BigInteger b = BigInteger.valueOf(l);
                b = b.modPow(b, TEN_B);
                long l1 = b.longValue();
                cache.put(l, l1);
            }
        }

        long solver(long N) {
            Map.Entry<Long, Long> longLongEntry = pre_calc.floorEntry(N);
            long res = longLongEntry.getValue();
            long start = longLongEntry.getKey();

            for (long l = start; l <= N; l++) {
                if (l % 10 == 0) {
                    continue;
                }
                if (l % 5 == 0 && l - 5120 >= 15) {
                    long l2 = l % 5120;
                    if (cache.containsKey(l2)) {
                        res += cache.get(l2);
                        continue;
                    }
                }
                BigInteger b = BigInteger.valueOf(l);
                b = b.modPow(b, TEN_B);
                long l1 = b.longValue();
                res += l1;
                if (res > HALF_LONG) {
                    res %= TEN;
                }
            }
            return res % TEN;
        }

        long solver2(long N) {
            long res = 0;
            for (long l = 1; l <= N; l++) {
                if (l % 10 == 0) {
                    continue;
                }
                BigInteger b = BigInteger.valueOf(l);
                b = b.modPow(b, TEN_B);
                long l1 = b.longValue();
                res += l1;
                if (res > HALF_LONG) {
                    res %= TEN;
                }
            }
            return res % TEN;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        Solution sol = new Solution();
        System.out.println(sol.solver(N));

    }
}
