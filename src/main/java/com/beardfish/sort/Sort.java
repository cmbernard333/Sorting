package com.beardfish.sort;

import java.util.Comparator;
import java.util.List;

public interface Sort {
	public <T> void sort(List<T> list,Comparator<T> comparator);
}
