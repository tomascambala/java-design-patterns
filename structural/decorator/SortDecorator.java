package structural.decorator;

import java.util.Arrays;

interface SortingStrategy {
    void sort(int[] arr);
}

class BubbleSort implements SortingStrategy {
    public void sort(int[] arr) {
        int lastIdx = arr.length;
        for (int i = 0; i < lastIdx - 1; i++) {
            for (int j = 0; j < lastIdx - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int num = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = num;
                }
            }
        }
    }
}

class QuickSort implements SortingStrategy {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int lowest, int highest) {
        if (lowest < highest) {
            int p = partition(arr, lowest, highest);
            quickSort(arr, lowest, p - 1);
            quickSort(arr, p + 1, highest);
        }
    }

    private int partition(int[] arr, int lowest, int highest) {
        int pivot = arr[highest];
        int i = lowest - 1;
        for (int j = lowest; j < highest; j++) {
            if (arr[j] < pivot) {
                i++;
                int num = arr[i];
                arr[i] = arr[j];
                arr[j] = num;
            }
        }
        int num = arr[i + 1];
        arr[i + 1] = arr[highest];
        arr[highest] = num;
        return i + 1;
    }
}

class Sorter {
    private SortingStrategy strategy;

    public Sorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr) {
        strategy.sort(arr);
    }
}

class SortDecorator {
    public static void main(String[] args) {
        int[] arr = { 9, 123, 12, 345, 45, 97 };
        Sorter sorter = new Sorter(new BubbleSort());
        sorter.sort(arr);
        System.out.println("Bubble sorting ... " + Arrays.toString(arr));
        sorter.setStrategy(new QuickSort());
        sorter.sort(arr);
        System.out.println("Quick sorting ... " + Arrays.toString(arr));
    }
}
