package com.beardfish.test.sort;

import com.beardfish.sort.MergeSort;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by christian on 2/17/14.
 */
public class MergeSortTest {

    @Test
    public void sortTestMergeSort() {
        List<Integer> numbers = new LinkedList<Integer>()  {{
            add(1);
            add(10);
            add(27);
            add(7);
            add(3);
            add(0);
        }};
        MergeSort mergeSort = new MergeSort();
        mergeSort.<Integer>sort(numbers,new IntegerComparator());
        System.out.println(numbers.toString());
    }
}
