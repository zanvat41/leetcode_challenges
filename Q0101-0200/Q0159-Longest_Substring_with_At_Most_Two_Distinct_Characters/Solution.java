class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; // left pointer
        int i = 0; // right pointer
        int maxLen = 0;
        while (i < s.length()) {
            // update the map with the right pointer
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }

            // move left pointer until map's size less than 3
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                }
                left++;
            }

            maxLen = Math.max(maxLen, i - left + 1);
            i++;
        }
        return maxLen;
    }
}
