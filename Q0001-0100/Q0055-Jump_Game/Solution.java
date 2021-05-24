class Solution {
    public boolean canJump(int[] nums) {
        int currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(farthest, i + nums[i]);
            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                currentJumpEnd = farthest;
            }
        }
        return currentJumpEnd >= nums.length -1;
    }
}
