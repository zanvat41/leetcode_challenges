class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        else if(x < 10) return true;

        int reverted = 0;

        while(x > reverted) {
            reverted = reverted * 10 + (x % 10);
            x /= 10;
        }

        return x == reverted || x == reverted/10;
    }
}