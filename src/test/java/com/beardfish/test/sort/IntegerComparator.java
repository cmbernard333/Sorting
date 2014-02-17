package com.beardfish.test.sort;

import java.util.Comparator;

/**
 * Created by christian on 2/17/14.
 */
public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer intA, Integer intB) {
        return intA.compareTo(intB);
    }
}
