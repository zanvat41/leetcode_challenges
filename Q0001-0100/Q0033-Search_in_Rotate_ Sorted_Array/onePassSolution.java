class onePassSolution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            // left side is a non-rotated subarray(pivot is in the right side)
            else if (nums[mid] >= nums[start]) {
                // check if target is in range of left side
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            // right side is a non-rotated subarray(pivot is in the left side)
            else {
                // check if target is in range of right side
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
