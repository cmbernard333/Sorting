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
    public void sortTestMergeSortInt() {
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

    @Test
    public void sortTestMergeSortString() {
        List<String> strings = new LinkedList<String>() {{
            add("garbage");
            add("apple");
            add("baby");
            add("revolution");
            add("baby");
            add("alpha");
            add("rock");
            add("orphan");
            add("xylophone");
        }};
        MergeSort mergeSort = new MergeSort();
        mergeSort.<String>sort(strings,new StringComparator());
        System.out.println(strings.toString());
    }
}
