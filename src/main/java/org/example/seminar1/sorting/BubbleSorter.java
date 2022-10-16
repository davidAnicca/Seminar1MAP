package org.example.seminar1.sorting;

public class BubbleSorter extends AbstractSorter {


    @Override
    public int[] sort(int[] numbers) {
        int n = numbers.length;
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for(int i = 0; i < n-1; i++){
                if(numbers[i] > numbers[i+1]){
                    int aux = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = aux;
                    sorted = false;
                }
            }
        }
        return numbers;
    }
}
