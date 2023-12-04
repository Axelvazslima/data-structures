package algorithms.sorting.insertionsort;

import java.util.Arrays;

import algorithms.PiecesOfCodeIMayNeed;

public class InsertionSort {
    private static int[] nums = PiecesOfCodeIMayNeed.nums.clone();

    public static void main(String[] args) {
        PiecesOfCodeIMayNeed.welcomeMessage();

        forLoopImplementationInsertionSort(nums);

        PiecesOfCodeIMayNeed.goodbyeMessage();
    }

    private static void forLoopImplementationInsertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {

            for (int j = i; j > 0; j--) {

                // Modifying the sign from > to < orders it in reverse
                if (nums[j] > nums[j - 1]) {
                    break;
                }

                PiecesOfCodeIMayNeed.swap(nums, j, j - 1);
            }
        }

        System.out.println("\nFor Loop Implementation: " + Arrays.toString(nums) + "\n");
    }
}
