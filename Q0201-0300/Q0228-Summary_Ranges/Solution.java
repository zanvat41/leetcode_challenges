class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        int start = 0, end = 0;
        while(start < nums.length) {
            while(end < nums.length && nums[end] - nums[start] == end - start) end++;
            if(start == end - 1) res.add(""+nums[start]);
            else res.add(nums[start]+"->"+nums[end - 1]);
            start = end;

        }
        return res;
    }
}