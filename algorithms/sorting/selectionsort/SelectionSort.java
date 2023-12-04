package algorithms.sorting.selectionsort;

import java.util.Arrays;

// N² time complexity
// Selects the lowest element (minimum) and insert it into the first spot
public class SelectionSort {
    private static int[] nums = {2, 1, 2, 4, 1, 5, 10, 2, 7, 5, 6, 9, 23, 20, 24, 627};

    public static void main(String[] args) {
        System.out.println("The list is " + Arrays.toString(nums) + "\n");
        forImplementationSelectionSort(nums);
        whileImplementationSelectionSort(nums);
        recursionImplementationSelectionSort(nums, 0);
    }

    private static void forImplementationSelectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        System.out.println("The For Loop implemenation:\n" + Arrays.toString(nums) + "\n");
    }

    private static void whileImplementationSelectionSort(int[] nums){
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int minIndex = i;
            while (j < nums.length) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
                j++;
            }
            swap(nums, i, minIndex);
            i++;
        }
        System.out.println("\nThe While Loop implementation:\n" + Arrays.toString(nums) + "\n");
    }

    // Outer step of the recursive solution for the Selection Sort Algorithm
    private static void recursionImplementationSelectionSort(int[] nums, int position){
        if (position >= nums.length - 1) {
            System.out.println("\nRecursive approach:\n" + Arrays.toString(nums) + "\n");
            return;
        }
        swap(nums, position, innerStepRecursion(nums, position));
        position += 1;
        recursionImplementationSelectionSort(nums, position);
    }

    // Inner step of the Selection Sort Algorithm
    private static int innerStepRecursion(int[] nums, int position){
        int minIndex = position;
        if (position < nums.length - 1) {
            if (nums[minIndex] > nums[position]) {
                minIndex = position;
                position += 1;
                return innerStepRecursion(nums, position);
            }
        }
        return minIndex;
    }

    // My implementation of the swap method to change where the elemnts are placed in the collection (Array, in this case)
    private static int[] swap(int[] nums, int index, int indexMin){
        int a = nums[index];
        nums[index] = nums[indexMin];
        nums[indexMin] = a;
        return nums;
    }
}
