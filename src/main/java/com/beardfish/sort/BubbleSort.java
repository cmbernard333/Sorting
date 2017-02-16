package com.beardfish.sort;

import java.util.List;
import java.util.Comparator;

public class BubbleSort implements Sort {
	public <T> void sort(List<T> list, Comparator<T> comp) {
		this.BubbleSort(list,comp);
	}

	private <T> void BubbleSort(List<T> list, Comparator<T> comp) {
		T temp = null;
		/* i just keeps track of where you start */
		for(int i = 0; i < list.size()-1; i++) {
			/**
				with each pass your array is more sorted AND the index
			with which you start (i) gets larger so you compare less values
			**/
			for(int j = 0; j < list.size()-i-1; j++) {
				if(comp.compare(list.get(j),list.get(j+1))>0) {
					temp = list.get(j);
					list.set(j,list.get(j+1));
					list.set(j+1,temp);
				}
			}
		}

	}

	private <T> void BubbleSortRecursive(List<T> list, Comparator<T> comp) {
		this.BubbleSortRecursiveHelper(list, comp, list.size());
	}

	private <T> void BubbleSortRecursiveHelper(List<T> list, Comparator<T> comp, int size) {
		T temp = null;
		/* base case is array is of size 1 - already sorted*/
		if(size==1)
			return;

		/* swap the values */
		for(int i = 0;i<size-1;i++) {
			if(comp.compare(list.get(i),list.get(i+1))>0) {
				temp = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
			}
		}
		/* call the outer loop */
		BubbleSortRecursiveHelper(list,comp,size-1);
	}
}