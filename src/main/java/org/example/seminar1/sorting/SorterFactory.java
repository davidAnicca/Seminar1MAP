package org.example.seminar1.sorting;

import org.example.seminar1.factories.Strategy;

public class SorterFactory {
    public static SorterFactory instance = new SorterFactory();

    private SorterFactory() {

    }

    public static SorterFactory getInstance() {
        return instance;
    }

    public AbstractSorter createSorter(SortingStrategy strategy){
        if(strategy == SortingStrategy.BUBBLESORT)
            return new BubbleSorter();
        if(strategy == SortingStrategy.MERGESORT)
            return new MergeSorter();
        return null;
    }
}
