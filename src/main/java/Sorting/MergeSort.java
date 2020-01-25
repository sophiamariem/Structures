package Sorting;

public class MergeSort {

    public int[] mergeSort(int[] array) {
        return mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left >= right) {
            return array;
        }
        int middle = (left + right) / 2;
        mergeSort(array, tempArray, left, middle);
        mergeSort(array, tempArray, middle + 1, right);
       return mergeHalves(array, tempArray, left, right);
    }

    private int[] mergeHalves(int[] array, int[] tempArray, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftStart;

        // while still in bounds
        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (array[leftIndex] <= array[rightIndex]) {
                tempArray[index] = array[leftIndex];
                leftIndex++;
            } else {
                tempArray[index] = array[rightIndex];
                rightIndex++;
            }
            index++;
        }

        // only one of these (left or right) actually will have remaining elements, because of the while loop
        System.arraycopy(array, leftIndex, tempArray, index, leftEnd - leftIndex + 1);
        System.arraycopy(array, rightIndex, tempArray, index, rightEnd - rightIndex + 1);

        System.arraycopy(tempArray, leftStart, array, leftStart, size);

        return array;
    }
}
