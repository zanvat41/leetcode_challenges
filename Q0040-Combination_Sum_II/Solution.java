class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        Arrays.sort(candidates);
        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }

    protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int start, int[] candidates,
            List<List<Integer>> results) {

        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            if (remain - candidates[i] < 0) break;

            comb.add(candidates[i]);
            backtrack(remain - candidates[i], comb, i + 1, candidates, results);
            comb.removeLast();
        }

    }
}
