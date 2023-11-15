package fundamentals;

// Recursion Example.
// Major topic when it comes to algorithms.
// Loop logic without using it.
// If you don't have a base case, it's going to loop forever. And if you get a single detail wrong, the same exact thing is probably going to happen, so you must really know what you are doing, and for that, you must be consistent in practicing to get confident with it.

public class Recursion {
    public static void main(String[] args) {
        System.out.println("This code is an example of recursion.\nIt doesn't use a traditional loop whatsoever, but it works just like one.");

        int counter = 0;

        // Starting from 0
        System.out.println(Recursion.recursionFundamentals(counter));
        System.out.println("\n------------------------------\n");

        // Starting from 1
        System.out.println(Recursion.recursionFundamentals(++counter));
    }

    private static int recursionFundamentals(int counter){

        // Base Case
        // O(1);

        if (counter < 10) {
            System.out.println(counter);
            return Recursion.recursionFundamentals(counter + 1);
        } return counter;
    }
}
