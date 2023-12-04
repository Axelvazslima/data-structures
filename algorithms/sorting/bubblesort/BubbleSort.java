package algorithms.sorting.bubblesort;

import java.util.Arrays;

import algorithms.PiecesOfCodeIMayNeed;

public class BubbleSort {
    private static int[] nums = PiecesOfCodeIMayNeed.nums.clone();
    public static void main(String[] args) {
        PiecesOfCodeIMayNeed.welcomeMessage();

        forLoopImplementationBubbleSort(nums);

        PiecesOfCodeIMayNeed.goodbyeMessage();
    }

    private static void forLoopImplementationBubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    PiecesOfCodeIMayNeed.swap(nums, j, j + 1);
                }
            }
        }
        System.out.println("\nThe For Loop Implementation of the Bubble Sort: " + Arrays.toString(nums) + "\n");
    }
}
