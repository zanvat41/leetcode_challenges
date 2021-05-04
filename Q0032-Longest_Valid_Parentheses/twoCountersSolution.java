class twoCountersSolution {
    public int longestValidParentheses(String s) {
        int res = 0, l = 0, r = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') l++;
            else r++;

            if(l == r) res = Math.max(res, 2*r);
            else if(r > l) {
                l = 0;
                r = 0;
            }
        }
        l = 0;
        r = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '(') l++;
            else r++;

            if(l == r) res = Math.max(res, 2*r);
            else if(r < l) {
                l = 0;
                r = 0;
            }
        }
        return res;
    }
}
