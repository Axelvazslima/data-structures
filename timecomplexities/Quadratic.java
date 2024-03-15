package timecomplexities;

// Quadratic Time Complexity
// O(n²)

public class Quadratic {
    public static void main(String[] args) {

        int[] numbers = {3, 2, 1, 22, 4, 99,5 ,6, 7, 9, 101, 10, 11, 101, 6, 2004, 2006};
        System.out.println(Quadratic.printAllPairs(numbers));
    }

    private static String printAllPairs(int[] numbers){
        int counter = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                System.out.println("Pair number " + counter + ": (" + numbers[i] + " , " + numbers[j] + ")");

                counter++;
            }
        }

        return "The size of the Array is: " + numbers.length + "\nThe number of times the array was looped over was: " + counter;
    }
}
