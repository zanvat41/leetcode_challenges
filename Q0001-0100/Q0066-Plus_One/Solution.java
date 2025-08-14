class Solution {
    public int[] plusOne(int[] digits) {
        return helper(digits, digits.length - 1);
    }

    public int[] helper(int[] digits, int index){
        if(index < 0) {
            // all digits are 9
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        else {
            int digit = digits[index];
            digits[index] = (digit + 1) % 10;
            if(digit < 9) return digits;
            else return helper(digits, index-1);
        }
    }
}