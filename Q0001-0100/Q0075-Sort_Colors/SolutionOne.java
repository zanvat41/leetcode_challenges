class SolutionOne {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length -1;
        int i =0;
        while(i <= twoIndex) {
            if (nums[i] == 0) {
                nums[i] = nums[i] + nums[zeroIndex];
                nums[zeroIndex] = nums[i] - nums[zeroIndex];
                nums[i] = nums[i] - nums[zeroIndex];
                zeroIndex++;
                i++;
            }
            else if (nums[i] == 2) {
                nums[i] = nums[twoIndex];
                nums[twoIndex] = 2;
                twoIndex--;

            }
            else{
                i++;
            }
        }
    }
}
