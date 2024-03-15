package timecomplexities;

// Linear code Sample using java
// O(n)

public class Linear {
    public static void main(String args[]){
        System.out.println("This code will try to find the number 2 in a given Array.");

        int[] numbers = {1, 3, 4, 5, 6, 7, 8, 22, 9, 2, 1, 9, 10, 11};
        System.out.println(Linear.findNumberTwo(numbers));
    }

    private static String findNumberTwo(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 2) return "Number two find.\nPosition from 1: " + (i + 1) + "\nIndex: " + i;
        }
        return "Number not found";
    }
}