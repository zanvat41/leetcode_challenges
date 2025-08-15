class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8 ,8);
        map.put(9, 6);

        int rotatedN = 0;
        int originalN = n;

        while(n > 0) {
            int digit = n % 10;
            Integer rotatedDigit = map.get(digit);
            if(rotatedDigit == null) return false;
            rotatedN = rotatedN * 10 + rotatedDigit;
            n = n / 10;
        }
        return rotatedN != originalN;
    }
}