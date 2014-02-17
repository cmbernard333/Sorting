package com.beardfish.test.sort;

import java.util.Comparator;

/**
 * Created by christian on 2/17/14.
 */
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String sA, String sB) {
        return sA.compareTo(sB);
    }
}
