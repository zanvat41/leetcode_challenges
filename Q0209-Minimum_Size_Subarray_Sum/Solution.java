class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // return binarySearchMethod(s, nums);
        return twoPointersMethod(s, nums);

    }

    private int twoPointersMethod(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s && left < n) {
                //System.out.println("hi");
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;

    }

    private int binarySearchMethod(int s, int[] nums) {
        // assume nums is not null
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0; // corresponding to map.put(0, -1), but index starts from 0
        // prefix[0] = 0, prefix[1] = nums[0], prefix[2] = nums[0] + nums[1], ...

        int minLen = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];

            // Find the largest index result such that
            // sum - prefix[result] >= s
            // which eqauls to prefix[result] <= sum - s
            int result = binarySearch(prefix, 0, i, sum - s);
            if (result != -1) { // <= sum - s
                int size = i - result + 1;
                minLen = Math.min(minLen, size);
            }

            prefix[i + 1] = sum;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // To find the one (<= key)
    // we use upper-bound BS to find (> key)
    // exists:     lo - 1 --> existing item
    // not exists: lo - 1 --> greatest item < key
    private int binarySearch(int[] nums, int lo, int hi, int key) {
        int oldLo = lo;
        int oldHi = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        lo -= 1;
        if (lo >= oldLo && lo <= oldHi) return lo;
        else return -1;
    }
}
