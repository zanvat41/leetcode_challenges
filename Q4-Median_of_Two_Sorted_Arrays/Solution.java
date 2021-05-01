class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // Do binary search on the shorter array
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int temp2 = m; m = n; n = temp2;
        }

        // Set the left and right bound of the range where to do binary search
        int il = 0, ir = m, halfLen = (m + n + 1) / 2;

        while(il <= ir) {
            // Index of next value x'
            // of the last value x contributed by nums1 to left half of nums1 U numsB
            int imx = (il + ir) / 2;
            // Index of next value y'
            // of the last value y contributed by nums2 to left half of nums1 U numsB
            int imy = halfLen - imx;

            // if y > x', increase the left bound of the binary search
            if (imx < ir && nums2[imy - 1] > nums1[imx])
                il= imx + 1;
                // if x > y', decrease the right bound of the binary search
            else if (imx > il && nums1[imx - 1] > nums2[imy])
                ir = imx - 1;

                // 1. if imx = ir or imx = il, it means il = ir,
                // no need to do binary search any further
                // 2. if y < x < y', x should be median or left part of median;
                // if x < y' < x', y should be median or left part of median.
            else {
                int midLeft;
                // Conrner case 1: no element in nums1 is contributed
                // to left half of nums1 U nums2
                if (imx == 0) midLeft = nums2[imy - 1];
                    // Conrner case 2: no elements in nums2 is contributed
                    // to left half of nums1 U nums2
                else if (imy == 0) midLeft = nums1[imx - 1];
                    // Normal case: median or left part of medianis x or y if
                else midLeft = Math.max(nums1[imx - 1], nums2[imy - 1]);

                // if m+n is odd
                if ((m + n) % 2 == 1)
                    return midLeft;

                // if m+n is even
                int midRight;
                // Conrner case 1: all elements in nums1 are contributed
                // to left half of nums1 U nums2
                if (imx == m) midRight = nums2[imy];
                    // Conrner case 2: all elements in nums2 are contributed
                    // to left half of nums1 U nums2
                else if (imy == n) midRight = nums1[imx];
                    // Normal case: right part of median is x' or y'
                else midRight = Math.min(nums1[imx], nums2[imy]);

                return (midLeft + midRight) / 2.0;

            }
        }
        return 0.0;
    }
}
