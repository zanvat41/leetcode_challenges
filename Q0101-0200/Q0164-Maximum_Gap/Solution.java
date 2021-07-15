class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 2) return 0;
        // get the max and min value of the array
        int min = nums[0];
        int max = nums[0];
        for (int num:nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max - min)/(n - 1));
        int[] bucketsMIN = new int[n - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[n - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for(int num : nums) {
            if(num == min || num == max) continue;

            int idx = (num - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(num, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(num, bucketsMAX[idx]);
        }

        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < n - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }

        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }
}
