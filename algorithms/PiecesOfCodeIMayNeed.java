package algorithms;

public class PiecesOfCodeIMayNeed {
    public static int[] nums = {2, 1, 2, 4, 1, 5, 10, 2, 7, 5, 6, 9, 23, 20, 24, 627};

    // My implementation of the swap method to change where the elemnts are placed in the collection (Array, in this case)
    public static int[] swap(int[] nums, int index, int indexMin){
        int temp = nums[index];
        nums[index] = nums[indexMin];
        nums[indexMin] = temp;
        return nums;
    }
}
