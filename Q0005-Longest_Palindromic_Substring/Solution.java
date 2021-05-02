class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int l = 0, r = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i); // odd length
            int len2 = expand(s, i, i + 1); // even length
            int len = Math.max(len1, len2);

            if(len > r - l) {
                l = i - (len - 1) / 2;
                r = i + len / 2;
                //System.out.println(s.substring(l,r+1));
            }
        }
        return s.substring(l, r + 1);
    }

    private int expand(String s, int left, int right) {
        int l = left, r = right;
        while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }
}
