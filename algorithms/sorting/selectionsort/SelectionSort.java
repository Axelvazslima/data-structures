package algorithms.sorting.selectionsort;

import java.util.Arrays;
import algorithms.PiecesOfCodeIMayNeed;

// N² time complexity
// Selects the lowest element (minimum) and insert it into the first spot
public class SelectionSort {
    private static int[] nums = PiecesOfCodeIMayNeed.nums;

    public static void main(String[] args) {
        PiecesOfCodeIMayNeed.welcomeMessage();

        forImplementationSelectionSort(nums);
        whileImplementationSelectionSort(nums);
        
        PiecesOfCodeIMayNeed.goodbyeMessage();
    }

    private static void forImplementationSelectionSort(int[] nums){
        int[] temp = nums.clone();
        for (int i = 0; i < temp.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[minIndex] > temp[j]) {
                    minIndex = j;
                }
            }
            PiecesOfCodeIMayNeed.swap(temp, i, minIndex);
        }
        System.out.println("The For Loop implemenation:\n" + Arrays.toString(temp) + "\n");
    }

    private static void whileImplementationSelectionSort(int[] nums){
        int[] temp = nums.clone();

        int i = 0;
        while (i < temp.length) {
            int j = i + 1;
            int minIndex = i;
            while (j < temp.length) {
                if (temp[minIndex] > temp[j]) {
                    minIndex = j;
                }
                j++;
            }
            PiecesOfCodeIMayNeed.swap(temp, i, minIndex);
            i++;
        }
        System.out.println("\nThe While Loop implementation:\n" + Arrays.toString(temp) + "\n");
    }
}
