class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};
        if(nums.length == 1) {
            if(nums[0] == target)
                return new int[]{0, 0};
            else
                return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};

        // find left bound
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l+r) / 2;
            if(nums[mid] == target){
                // check if left bound found
                if(mid == l || nums[mid - 1] != target){
                    res[1] = res[0] = mid;
                    break;
                }
                else
                    r = mid - 1;
            }
            else if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }

        // target not in array
        if (res[0] == -1)
            return new int[]{-1, -1};

        // find right bound
        l = res[0] + 1;
        r = nums.length - 1;
        while(l <= r) {
            int mid = (l+r) / 2;
            if(nums[mid] == target){
                // check if right bound found
                if(mid == r || nums[mid + 1] != target){
                    res[1] = mid;
                    break;
                }
                else
                    l = mid + 1;
            }
            else if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return res;
    }
}
