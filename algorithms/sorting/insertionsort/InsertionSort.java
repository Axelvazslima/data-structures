package algorithms.sorting.insertionsort;

import java.util.Arrays;

import algorithms.PiecesOfCodeIMayNeed;

public class InsertionSort {
    private static int[] numsOG = PiecesOfCodeIMayNeed.nums, nums = PiecesOfCodeIMayNeed.nums.clone();

    public static void main(String[] args) {
        System.out.println("The original list is: " + Arrays.toString(numsOG) + "\n");

        forLoopImplementationInsertionSort(nums);

        System.out.println("\nNotice that it didn't change the original list (because I did not want to):\n" + Arrays.toString(numsOG) + "\n");
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
