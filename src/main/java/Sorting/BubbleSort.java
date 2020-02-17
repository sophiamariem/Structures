package Sorting;

public class BubbleSort {

    public int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        //optimization, because once we get to the end of array at the first sweep, the last element of the array
        // will be in place, second sweep, second to last in place and so on, so can shrink unsorted portion
        int lastUnsorted = array.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i< lastUnsorted; i++) {
                if (array[i] > array[i+1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
        return  array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
