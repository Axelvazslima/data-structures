package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Parenthesis problem solved using the Stack data structure.
// O(n) time complexity solution.

public class ParenthesisProblem {
    public static void main(String[] args) {
        System.out.println("Leet Code exercise number 20.");

        String s = new String("()()[][]{{}}");

        System.out.println(ParenthesisProblem.isValid(s));
    }

    private static boolean isValid(String s) {
        Map<String, String> valids = new HashMap<>();
        valids.put("{", "}");
        valids.put("(", ")");
        valids.put("[", "]");

        List<String> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));

            if (valids.keySet().contains(cur)) {
                stack.add(cur);
            } else if (!stack.isEmpty() && cur.equals(valids.get(stack.get(stack.size() - 1)))) {
                stack.remove(stack.size() - 1);
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
