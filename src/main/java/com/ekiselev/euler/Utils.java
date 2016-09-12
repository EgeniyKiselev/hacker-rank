package com.ekiselev.euler;

import java.util.*;
import java.util.PrimitiveIterator.OfLong;
import java.util.stream.*;

/**
 * Created by ekiselev on 9/12/2016.
 */
public class Utils {

    public static LongStream longStream(Scanner scanner) {
        OfLong iter = new OfLong() {
            @Override
            public boolean hasNext() {
                while (!scanner.hasNextLong() && scanner.hasNext()) {
                    scanner.next();
                }
                return scanner.hasNext();
            }

            @Override
            public long nextLong() {
                return scanner.nextLong();
            }
        };
        return StreamSupport.longStream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
}
