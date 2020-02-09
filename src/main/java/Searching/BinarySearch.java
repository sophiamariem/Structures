package Searching;

import java.util.Arrays;

public class BinarySearch {

    public boolean recursiveSearch(int[] input, int target) {
        Arrays.sort(input);
        return recursiveSearch(input, target, 0, input.length - 1);
    }

    private boolean recursiveSearch(int[] input, int target, int left, int right) {
        if (left > right) {
            return false;
        }

        int mid = (left + right) / 2; // potential overflow so could have left + ((right - left) / 2);
        if (input[mid] == target) {
            return true;
        } else if (target < input[mid]) {
            return recursiveSearch(input, target, left, mid - 1);
        } else {
            return recursiveSearch(input, target, mid + 1, right);
        }
    }

    public boolean iterativeSearch(int[] input, int target) {
        Arrays.sort(input);

        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // potential overflow so could have left + ((right - left) / 2);
            if (input[mid] == target) {
                return true;
            } else if (target < input[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
