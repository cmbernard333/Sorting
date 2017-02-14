package com.beardfish.test.sort;

import com.beardfish.sort.InsertionSort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by christian on 2/17/14.
 */
public class InsertionSortTest {
	
	@Test
	public void sortTestInsertionSortTrivial() {
		List<Integer> numbers = new LinkedList<Integer>() {{
			add(5);
			add(1);
			add(6);
			add(2);
			add(4);
			add(3);
		}};
		InsertionSort InsertionSort = new InsertionSort();
		InsertionSort.<Integer>sort(numbers, new IntegerComparator());
		System.out.println(numbers.toString());
	}

    @Test
    public void sortTestInsertionSortInt() {
       List<Integer> numbers = new LinkedList<Integer>()  {{
            add(1);
            add(10);
            add(27);
            add(7);
            add(3);
            add(0);
        }};
        InsertionSort InsertionSort = new InsertionSort();
        InsertionSort.<Integer>sort(numbers,new IntegerComparator());
        System.out.println(numbers.toString());
    }

    @Test
    public void sortTestInsertionSortString() {
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
        InsertionSort InsertionSort = new InsertionSort();
        InsertionSort.<String>sort(strings,new StringComparator());
        System.out.println(strings.toString());
    }
    
    @Test
    public void sortRandom1000Intergers() {
    	List<Integer> randomNumbers = new ArrayList<Integer>(10000);
    	Random random =  new Random();
    	InsertionSort InsertionSort = new InsertionSort();
    	for(int i = 0; i<10000;i++) {
    		randomNumbers.add(random.nextInt());
    	}
    	long start = System.nanoTime();
    	InsertionSort.sort(randomNumbers, new IntegerComparator());
    	double elapsedTime = ((double)(System.nanoTime()-start))/1000000000;
    	System.out.println("Elapsed Time: "+(elapsedTime));
    }
}
