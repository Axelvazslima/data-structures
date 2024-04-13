import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        String aux;
        Map<String, Integer> chars = new HashMap<>();
        int max_length = 0;
        int length = 0;
        String[] charsArray = s.split("");
        for(int i = 0; i < charsArray.length; i++){
            if (chars.get(charsArray[i]) != null){
                length = 0;
                i = chars.get(charsArray[i]) + 1;
                chars.clear();
            }
            chars.put(charsArray[i], i);
            length++;
            if(max_length < length) max_length = length;
        }
        return max_length;
    }
}
