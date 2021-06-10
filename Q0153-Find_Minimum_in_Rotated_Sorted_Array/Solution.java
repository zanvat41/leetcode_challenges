class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if(nums[0] < nums[nums.length - 1])
            return nums[0];
        int pivot = find_pivot(nums, 0, nums.length - 1);
        return nums[pivot];

    }
    public int find_pivot(int[] nums, int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }
}
