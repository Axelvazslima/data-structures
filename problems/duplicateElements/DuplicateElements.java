// College Problem

package problems.duplicateElements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class DuplicateElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";

        try{
        while ((line = br.readLine()) != null) {
            String[] array = line.split("\\s+");
            System.out.println(verifyDuplicatesSet(array));
            
        }
        } catch (Exception e){}

        sc.close();
    }

    private static boolean verifyDuplicatesMap(String[] nums){
        Map<String, String> a = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (a.get(nums[i]) == null) {
                a.put(nums[i], nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean verifyDuplicatesSet(String[] nums){
        Set<String> a = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!(a.add(nums[i]))){
                return true;
            }
        }
        return false;
    }
    
    private static boolean verifyDuplicatesFor(String[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = (i + 1); j < nums.length; j++) {
                if (nums[i].equals(nums[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}