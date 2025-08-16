class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = -1;

        for(int num : map.keySet()) {
            if(map.get(num) == 1 && num > res) {
                res = num;
            }
        }

        return res;
    }
}