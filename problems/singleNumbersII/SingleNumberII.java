class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.get(nums[i]) != null) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }

        for(int i : map.keySet()){
            if(map.get(i) == 1) return i;
        }
        return -1;
    }
}
