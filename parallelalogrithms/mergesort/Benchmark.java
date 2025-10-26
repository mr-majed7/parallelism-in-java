package parallelalogrithms.mergesort;

import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
        int size = 50_000_000;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int val = rand.nextInt(0, 9);
            arr1[i] = val;
            arr2[i] = val;
        }

        // Sequential Merge Sort timing
        int[] seqArr = arr1.clone();
        long start = System.nanoTime();
        MergeSort.sort(seqArr);
        long end = System.nanoTime();
        System.out.println("Sequential MergeSort: " + (end - start) / 1_000_000.0 + " ms");

        // Parallel Merge Sort timing
        int[] parArr = arr2.clone();
        start = System.nanoTime();
        ParallelMergeSort.sort(parArr);
        end = System.nanoTime();
        System.out.println("Parallel MergeSort: " + (end - start) / 1_000_000.0 + " ms");
    }
}
