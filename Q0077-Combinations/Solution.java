class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rs = new ArrayList();
        List<Integer> l = new ArrayList();
        helper(rs, l, n, k, 1);
        return rs;
    }

    private void helper(List<List<Integer>> rs, List<Integer> l, int n, int k, int i) {
        if(k == 0){
            rs.add(new ArrayList(l));
            return;
        }
        for(int j = i; j <= n - k + 1; j++) {
            l.add(j);
            helper(rs, l, n, k - 1, j + 1);
            l.remove(l.size() - 1);
        }

    }
}
