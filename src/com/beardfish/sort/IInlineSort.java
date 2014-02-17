package com.beardfish.sort;

import java.util.Comparator;
import java.util.List;

public interface IInlineSort {
	public <T> void sort(List<T> list,Comparator<T> comparator);
}
