package com.beardfish.test.sort;

import com.beardfish.sort.PatienceSort;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import org.junit.*;

public class PatienceSortTest {
	

	@Test
	public void testPatienceSortTrivial() {
		PatienceSort psort = new PatienceSort();
		List<Integer> numbers = new LinkedList<Integer>() {{
			add(8);
			add(3);
			add(9);
			add(1);
			add(2);
			add(1);

		}};
		psort.<Integer>sort(numbers, new IntegerComparator());
		System.out.println(numbers);
	}

    @Test
    public void sortRandom1000Integers() {
    	List<Integer> randomNumbers = new ArrayList<Integer>(10000);
    	Random random =  new Random();
    	PatienceSort psort = new PatienceSort();
    	for(int i = 0; i<10000;i++) {
    		randomNumbers.add(random.nextInt());
    	}
    	long start = System.nanoTime();
    	psort.sort(randomNumbers, new IntegerComparator());
    	double elapsedTime = ((double)(System.nanoTime()-start))/1000000000;
    	System.out.println("Elapsed Time: "+(elapsedTime));
    }

}