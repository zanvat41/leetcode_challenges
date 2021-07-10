class Solution {
    public void reverseWords(char[] s) {
        // reverse the array
        for(int i = 0; i < s.length / 2; i++){
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }

        // reverse each word
        int l = 0, r = 0;
        while(r < s.length) {
            if(r + 1 == s.length || s[r+1] == ' ') {
                // reverse current word
                for(int i = 0; i <= (r - l) / 2; i++){
                    char temp = s[l + i];
                    s[l+i] = s[r - i];
                    s[r - i] = temp;
                }
                r = r+2;
                l = r;
            }
            else{
                r++;
            }
        }
    }
}
