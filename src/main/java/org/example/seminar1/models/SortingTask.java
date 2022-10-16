package org.example.seminar1.models;

import org.example.seminar1.sorting.AbstractSorter;
import org.example.seminar1.sorting.SorterFactory;
import org.example.seminar1.sorting.SortingStrategy;

public class SortingTask extends Task{
    private SortingStrategy strategy;
    private int[] numbers;
    private AbstractSorter sorter;
    public SortingTask(String taskID, String description, SortingStrategy strategy, int[] numbers) {
        super(taskID, description);
        this.strategy = strategy;
        this.numbers = numbers;
    }
    @Override
    public void execute() {
        sorter = SorterFactory.getInstance().createSorter(strategy);
        int[]sorted  = sorter.sort(numbers);
        for(int i:sorted)System.out.println(i);
    }
}
