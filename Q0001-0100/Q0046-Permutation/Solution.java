public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList();
        List<Integer> l = new ArrayList();
        int[] c = new int[nums.length];
        for(int i = 0;  i < c.length; i++) {
            c[i] = 1;
        }
        helper(nums, c, l, rs);
        return rs;
    }

    private void helper(int[] n, int[] c, List<Integer> l, List<List<Integer>> rs) {
        for(int i = 0; i < n.length; i++) {
            if(c[i] > 0) {
                c[i]--;
                //System.out.println(i);
                l.add(n[i]);
                if(l.size() == n .length){
                    //System.out.println(l.size());
                    List<Integer> l1 = new ArrayList(l);
                    rs.add(l1);
                }
                else{
                    helper(n, c, l, rs);
                }
                int index = l.indexOf(n[i]);
                l.remove(index);
                c[i]++;
                //System.out.println(c[i]);
            }
        }

    }
}
