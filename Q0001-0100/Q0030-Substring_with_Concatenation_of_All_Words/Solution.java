class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(words.length==0 || s==null || s.length()==0) return list;
        Map<String, Integer> need = new HashMap<>();
        // Store all the words in the array
        // into a map with the number count of each of them
        for(String word: words) {
            if(need.containsKey(word)) {
                need.put(word, need.get(word)+1);
            } else {
                need.put(word, 1);
            }
        }

        int n = words[0].length(), m = words.length;
        // i = 0, 1, ..., n-2, n -1
        // The i = n round would repeat i = 0 round,
        // except for checking substring s[0, n-1].
        // No need to repeat.
        for(int i = 0; i < n; i++) {
            // Use this map tp keep track of words in the window
            Map<String, Integer> find = new HashMap<>();
            // Count the legal words in the current window
            int count = 0;
            // start is the index of left bound of the window,
            // j is the index of first char of the substring
            for(int start = i, j = i; j + n <= s.length(); j += n) {
                String sub = s.substring(j, j+n);
                // The current substring is not in the array words,
                // update the left bound of window, reset count and map
                if(!need.containsKey(sub)) {
                    count = 0;
                    start = j + n;
                    find.clear();
                    continue;
                }
                while (find.get(sub) != null && find.get(sub) > need.get(sub)) {
                    String subStart = s.substring(start, start + n);
                    find.put(subStart, find.get(subStart) - 1);
                    count--;
                    start += n;
                }

                find.put(sub, (find.get(sub) == null ? 1 : find.get(sub)) + 1);
                count++;

                // Found a valid window
                if(count == m)
                    list.add(start);
            }
        }
        return list;
    }
}
