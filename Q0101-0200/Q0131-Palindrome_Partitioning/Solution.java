class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        isPalindrome[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            expandFromCenter(s, i - 1, i, isPalindrome);
            expandFromCenter(s, i, i, isPalindrome);
        }
        List<List<String>> palindromes = new ArrayList<>();
        partition(isPalindrome, s, 0, new LinkedList<>(), palindromes);
        return palindromes;
    }

    private void expandFromCenter(String s, int i, int j, boolean[][] isPalindrome) {
        int left = i;
        int right = j;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            isPalindrome[left][right] = true;
            left--;
            right++;
        }
    }

    private void partition(boolean[][] isPalindrome, String s, int start, LinkedList<String> partitions, List<List<String>> palindromes) {
        if (start == s.length()) {
            palindromes.add(new ArrayList<>(partitions));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                partitions.addLast(s.substring(start, i + 1));
                partition(isPalindrome, s, i + 1, partitions, palindromes);
                partitions.removeLast();
            }
        }
    }
}
