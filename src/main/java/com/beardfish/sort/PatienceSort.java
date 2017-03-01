package com.beardfish.sort;

import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;

public class PatienceSort implements Sort {
	
	public <T> void sort(List<T> list,Comparator<T> comparator) {
		List<List<T>> piles = deal(list,comparator);
		mergeNaive(list,piles,comparator);
	}

	public <T> List<List<T>> deal(List<T> list, Comparator<T> comparator) {
		/* placing on top of piles */
		List<List<T>> piles = new LinkedList<>();
		List<T> pile = null;
		T newEle = null;
		piles.add(new LinkedList()); // start out with one
		for(int i = 0;i<list.size();i++) {
			newEle = list.get(i);
			for(int j = 0; j<list.size();j++) {

				/* the top of each pile */
				if(j==piles.size()) {
					pile = new LinkedList<>();
					piles.add(pile);
				}
				pile = piles.get(j);

				/* nothing in this pile - add the newElement */
				if(pile.isEmpty()) {
					pile.add(newEle);
					break;
				}

				/* grab the top of the pile - i.e. the end */
				/* comparator.compare(topOfPile, newElement) > 0 means the top element comes after or is equal to */
				if( comparator.compare(pile.get(0), newEle) >= 0 ) {
					pile.add(0,newEle);
					break;
				}
			}
		}
		return piles;
	}

	/* top of each pile should be the minimum card */
	public <T> void mergeNaive(List<T> list, List<List<T>> piles, Comparator<T> comparator) {
		List<T> pile = null;
		int numPiles = piles.size();
		int i = 0;
		int j = 0;
		int minimumPile = 0;
		T minimum = null;
		while(numPiles > 0) {

			/* j starts at 0 */
			pile = piles.get(j);
			if(pile.isEmpty()) {
				numPiles--;
				j++;
				continue;
			}

			/* reset the minimum and minimumPile */
			if(minimum == null) {
				minimum = pile.get(0);
				minimumPile = j;
			}

			/* remove the top of the pile and move on */
			if(comparator.compare(minimum,pile.get(0))>0) {
				minimumPile = j;
			}

			/* end of piles list */
			if(j==piles.size()-1) {
				list.set(i, piles.get(minimumPile).remove(0));
				minimum = null;
				j = 0;
				i++;
			} else {
				j++;
			}
		}
	}

	public <T> void mergeFast(List<T> list, List<List<T>> piles) {
		/* uses priority queue */
	}

	private class ListFirstElementComparator <E> implements Comparator<List<E>> {
		@Override
		public int compare(List<E> l1, List<E> l2) {
			if(l1.size() >0 && l2.size() > 0) {
				Comparable<? super E> l1Val = (Comparable<? super E>)l1.get(0);
				return l1Val.compareTo(l2.get(0));
			} else if(l1 == null || l1.size() == 0) {
				return 1;
			} else if(l2 == null || l2.size() == 0) {
				return -1;
			}
			return 0;
		}
	}

	static <T> void printPiles(List<List<T>> piles) {
		System.out.println("Number of piles: "+piles.size());
		for(int i = 0;i<piles.size();i++) {
			System.out.println(piles.get(i));
		}
	}

}