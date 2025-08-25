class Solution {
    public int countLetters(String s) {
        int total = 0;
        for(int left = 0, right = 0; right <= s.length(); right++) {
            if(right == s.length() || s.charAt(left) != s.charAt(right)) {
                int lenSubstring = right - left;
                total += (1 + lenSubstring) * lenSubstring / 2;
                left = right;
            }
        }
        return total;
    }
}