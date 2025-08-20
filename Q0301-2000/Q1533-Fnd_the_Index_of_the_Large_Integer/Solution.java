/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y]
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0;
        int length = reader.length();
        while (length > 1) {
            length /= 2;
            // The left subarray starts from index left and the right part starts from left + length, both subarrays have length elements.
            final int cmp = reader.compareSub(left, left + length - 1, left + length, left + length + length - 1);
            if (cmp == 0) {
                // The extra element is the larger integer.
                return left + length + length;
            }
            if (cmp < 0) {
                left += length;
            }
        }
        return left;

    }
}