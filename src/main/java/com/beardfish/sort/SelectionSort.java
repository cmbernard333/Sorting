package com.beardfish.sort;

import java.util.List;
import java.util.Comparator;

public class SelectionSort implements Sort {

	public <T> void sort(List<T> list, Comparator<T> comparator)
	{
		this.selectionSort(list, comparator);
	}
	
	private <T> void selectionSort(List<T> list, Comparator<T> comparator)
	{
		int i, j = 0;
		int indexOfSmallest = 0;
		T temp = null;
		
		for(i = 0; i< list.size(); i++)
		{
			/* find the smallest value against the current i index */
			indexOfSmallest = i;
			for(j = i+1; j < list.size(); j++)
			{
				/* if the value at list[i] < list[j] */
				if(comparator.compare(list.get(j),list.get(indexOfSmallest)) < 0)
				{
					indexOfSmallest = j;
				}
			}
			temp = list.get(i);
			list.set(i, list.get(indexOfSmallest));
			list.set(indexOfSmallest, temp);
		}
	}

}