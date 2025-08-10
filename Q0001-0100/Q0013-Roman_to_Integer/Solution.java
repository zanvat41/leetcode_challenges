class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int n = s.length();
        int num = map.get(s.charAt(n - 1));
        int prev = num;
        for (int i = n - 2; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr < prev) {
                num -= curr;
            } else {
                num += curr;
            }
            prev = curr;
        }

        return num;
    }
}