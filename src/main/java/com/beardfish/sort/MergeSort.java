package com.beardfish.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements Sort{

	@Override
	public <T> void sort(List<T> lst,Comparator<T> comparator) {
		List<T> helper = new ArrayList<T>(lst);
		mergeSort(lst,helper,0,lst.size()-1,comparator);
	}
	
	/**
	 * Merge sort helper that does the actual sort
	 * @param l
	 * @param p
	 * @param r
	 */
	private <T> void mergeSort(List<T> l, List<T> helper, int p, int r,Comparator<T> comparator) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(l,helper,p,q,comparator);
			mergeSort(l,helper,q+1,r,comparator);
			merge(l,helper,p,q,r,comparator);
			
		}
	}
	
	/**
	 * Does a merge by creating sublists and pulling the maximum 
	 * Comparator : <0 = 1st<2nd; ==0 1st==2nd; >0 1st>2nd
	 * @param l -- the list being sorted
	 * @param p -- the first element in the list
	 * @param q -- the middle element of the list
	 * @param r -- the last element of the list
	 */
	private <T> void merge(List<T> l, List<T> helper, int p, int q, int r, Comparator<T> comparator) {
		/* index of list 1 */
		int i = p;
		/* index of list 2 */
		int j = q+1;
		/* index of helper list */
		int k = p;

		/* create helper list */
		for(int c = p; c <= r;c++) {
			helper.add(l.get(c));
		}

		while(i<=q && j<=r) {
			if(comparator.compare(helper.get(i),helper.get(j))<=0) {
				l.set(k, helper.get(i));
				i++;
			} else {
				l.set(k,helper.get(j));
				j++;
			}
			k++;
		}
		
		/* copy the remaining elements at k to the end of the list */
		while(i<=q) {
			l.set(k, helper.get(i));
			k++;
			i++;
		}
	}
}
