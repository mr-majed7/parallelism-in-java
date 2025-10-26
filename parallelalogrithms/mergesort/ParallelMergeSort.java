package parallelalogrithms.mergesort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort {
    public static void sort(int[] arr) {
        SortTask mainTask = new SortTask(arr);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    public static class SortTask extends RecursiveAction {
        private int[] arr;

        public SortTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void compute() {
            if (arr.length > 1) {
                int m = arr.length / 2;
                int[] firstHalf = new int[m];
                int[] secondHalf = new int[arr.length - m];

                System.arraycopy(arr, 0, firstHalf, 0, m);
                System.arraycopy(arr, m, secondHalf, 0, arr.length - m);

                SortTask firstHalfTask = new SortTask(firstHalf);
                SortTask secondHalfTask = new SortTask(secondHalf);
                invokeAll(firstHalfTask, secondHalfTask);

                MergeSort.merge(firstHalf, secondHalf, arr);

            }
        }

    }

}
