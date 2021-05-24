class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        // not rotated, do search directly
        if(nums[0] < nums[nums.length - 1])
            return search(nums, target, 0, nums.length - 1);

        int pivot = find_pivot(nums, 0, nums.length - 1);

        if(nums[pivot] == target) return pivot;
        // search left part
        if(target >= nums[0])
            return search(nums, target, 0, pivot);
            // search right part
        else
            return search(nums, target, pivot, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
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
