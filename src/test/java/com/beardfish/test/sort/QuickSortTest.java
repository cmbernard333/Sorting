package com.beardfish.test.sort;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import com.beardfish.sort.QuickSort;
import java.util.Random;

/**
 * Created by christian on 4/2/14.
 */
public class QuickSortTest {
    @Test
    public void testQuickSort() {
        List<Integer> list = new ArrayList<Integer>(10);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(4);
        QuickSort qsort = new QuickSort();
        qsort.sort(list,new IntegerComparator());
        System.out.println(list);
    }

    @Test
    public void testRandomSort() {
        List<Integer> list = new ArrayList<Integer>(1000);
        Random random = new Random();
        QuickSort qsort = new QuickSort();
        for(int i = 0; i<1000;i++) {
            list.add(random.nextInt());
        }
        long start = System.nanoTime();
        qsort.sort(list, new IntegerComparator());
        double elapsedTime = ((double)(System.nanoTime()-start))/1000000000;
        System.out.println("Elapsed Time: "+(elapsedTime));
    }
}
