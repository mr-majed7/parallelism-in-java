package parallelalogrithms.mergesort;

public class MergeSort {

    public static void sort(int[] arr) {
        if (arr.length > 1) {
            int m = arr.length / 2;
            int[] firstHalf = new int[m];
            int[] secondHalf = new int[arr.length - m];

            System.arraycopy(arr, 0, firstHalf, 0, m);
            System.arraycopy(arr, m, secondHalf, 0, arr.length - m);

            sort(firstHalf);
            sort(secondHalf);
            merge(firstHalf, secondHalf, arr);

        }
    }

    public static void merge(int[] firstHalf, int[] secondHalf, int[] arr) {
        int idxFirst = 0;
        int idxSecond = 0;
        int idxArr = 0;

        while (idxFirst < firstHalf.length && idxSecond < secondHalf.length) {
            if (firstHalf[idxFirst] < secondHalf[idxSecond]) {
                arr[idxArr++] = firstHalf[idxFirst++];
            } else {
                arr[idxArr++] = secondHalf[idxSecond++];
            }
        }

        while (idxFirst < firstHalf.length) {
            arr[idxArr++] = firstHalf[idxFirst++];
        }

        while (idxSecond < secondHalf.length) {
            arr[idxArr++] = secondHalf[idxSecond++];
        }
    }

}



