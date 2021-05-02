class Solution {
    public int myAtoi(String s) {
        int res = 0;
        int sign = 1;
        int i = 0;

        if(s == null) return 0;

        // Read in and ignore any leading whitespace.
        while(i < s.length() && s.charAt(i) == ' ')
            i++;

        // Check if the next character
        // (if not already at the end of the string) is '-' or '+'.
        //Read this character in if it is either. This determines if the final result is
        //negative or positive respectively. Assume the result is positive if neither is
        // present.
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            sign = (s.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i++) - '0');
        }
        return sign*res;
    }
}
