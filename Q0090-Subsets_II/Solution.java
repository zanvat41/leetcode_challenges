class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> solution = new ArrayList<>();
        helper(nums, 0, solution, result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> solution, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(solution));
            return;
        }
        solution.add(nums[index]);
        helper(nums, index + 1, solution, result);
        solution.remove(solution.size() - 1);
        // Skip duplicates
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        helper(nums, index + 1, solution, result);
    }
}
