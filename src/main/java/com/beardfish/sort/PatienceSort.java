package com.beardfish.sort;

public class PatienceSort implements Sort {
	
	public <T> void sort(List<T> list,Comparator<T> comparator) {
		List<List<T>> piles = deal(list,comparator);
		merge(list,piles);
	}

	public <T> List<List<T>> deal(List<T> list, Comparator<T> comparator) {
		/* placing on top of piles */
		List<List<T>> piles = new LinkedList<>();
		for(int i = 0;i<list.size();i++) {
			for(int j = 0; j<piles.length;j++) {

				/* the top of each pile */
				List<T> pile = piles.get(j);
				if(pile == null) {
					List<T> pile = new LinkedList<>();
					piles.set(j,pile);
				}

				/* nothing in this pile - add the element */
				if(pile.isEmpty()) {
					pile.add(list.get(i));
					break;
				}

				/* grab the top of the pile - i.e. the end */
				/* comparator.compare(topOfPile, newElement) > 0 means the top element comes after or is equal to */
				if( comparator.compare(pile.get(pile.size()-1), list.get(i) >= 0 ) {
					pile.add(list.get(i));
					break;
				}
			}
		}
		return piles;
	}

	/* top of each pile should be the minimum card */
	public <T> void merge(List<T> list, List<List<T>> piles) {
		List<T> pile = null;
		int numPiles = piles.length-1;
		int i = 0;
		int j = 0;
		while(numPiles > 0) {

			pile = piles.get(j);
			if(pile.isEmpty()) {
				numPiles--;
				continue;
			}

			/* remove the top of the pile and move on */
			list.set(i,piles.remove(piles.size()-1));

			i++;
		}
	}

}