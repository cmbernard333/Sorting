package com.beardfish.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Created by christian on 4/2/14.
 * Naive quicksort that uses in place sorting
 * Does not take into account the worst case of array already sorted
 * Does not use any heuristics to pick a good pivotIndex
 */
public class QuickSort implements Sort {
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        this.quickSort(list,comparator,0,list.size()-1);
    }

    public <T> void quickSort(List<T> list, Comparator<T> comparator, int left, int right) {
        while(left<right) {
            int pivotIndex = (left+right)/2;
            pivotIndex = partition(list,left,right,pivotIndex,comparator);
            // recursively sort the left and right parts of the array
            this.quickSort(list,comparator,left,pivotIndex-1);
            
            left = pivotIndex +1;
        }
    }

    public <T> int partition(List<T> list, int left, int right, int pivot, Comparator<T> comparator) {
        int storeIndex = left;
        // swap the pivot to the end
        T pivotValue = list.get(pivot);
        list.set(pivot,list.get(right));
        list.set(right,pivotValue);
        // exclude the pivot index because we already moved it
        for(int i = left; i<right;i++) {
            if(comparator.compare(list.get(i),pivotValue)<=0) {
                T temp = list.get(i);
                list.set(i,list.get(storeIndex));
                list.set(storeIndex,temp);
                storeIndex++;
            }
        }
        list.set(right,list.get(storeIndex));
        list.set(storeIndex,pivotValue);
        return storeIndex;
    }
}
