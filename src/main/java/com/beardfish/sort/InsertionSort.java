package com.beardfish.sort;

import java.util.Comparator;
import java.util.List;

/*
comparator.compare(x, y) < 0  x comes before y
comparator.compare(x, y) > 0  x comes after y
comparator.compare(x,y ) = 0  x and y are equal
*/

/* 5, 1, 6, 2, 4, 3 */

public class InsertionSort implements Sort {
	
	public <T> void sort(List<T> list,Comparator<T> comparator) {
		this.insertionSort(list,comparator);
	}
	
	private <T> void insertionSort(List<T> list, Comparator<T> comparator) {		
		int i,j = 0;
		T key = null;
		
		/* right side */
		for(i = 1; i < list.size(); i++) {
			key = list.get(i);
			/* left side */
			for( j = i-1; j>= 0; j--) {
				if(comparator.compare(key, list.get(j)) >=0) {
					break;
				}
				if(comparator.compare(key, list.get(j)) < 0) {
					list.set(j+1, list.get(j));
				}
			}
			list.set(j+1, key);
		}
	}	
}