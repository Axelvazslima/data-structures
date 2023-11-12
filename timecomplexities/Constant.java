package timecomplexities;

// Constant Time Complexity
// O(1)

public class Constant {
    public static void main(String[] args) {
        System.out.println("This code gives you the first element of a given array.");

        String[] sampleArray = {"I am the first element", "I am the second and last element, dont worry about me"};
        System.out.println(Constant.firstElementOfArray(sampleArray));
    }

    private static String firstElementOfArray(String[] numbers){
        if (numbers.length > 0) {
            return "The first element of this Array is: " + numbers[0];
        }

        return "The array is empty.";
    }
}
