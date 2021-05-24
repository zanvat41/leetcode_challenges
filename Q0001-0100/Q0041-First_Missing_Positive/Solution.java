class Solution {
    public int firstMissingPositive(int[] nums) {
        //if(nums.length == 0) return 0;
        //if(nums.length == 1) return nums[0] == 1 ? 2 : 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i+1 || nums[i] < 1 || nums[i] > nums.length)
                continue;
            if(nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i)
                return i + 1;
        }
        return nums.length + 1;
    }
}
