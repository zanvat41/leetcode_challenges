class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }
            map.put(c, j + 1);
            max = max > j - i + 1 ? max : j - i + 1;

        }
        return max;
    }
}
