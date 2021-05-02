class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int gap = 2*numRows - 2;


        for(int i = 0; i < numRows; i++) {
            for(int j = 0; i + j < n; j+=gap) {
                ret.append(s.charAt(i+j));
                // Add the one character on the slash
                if(i != 0 && i != numRows - 1 && j+gap-i < n)
                    ret.append(s.charAt(j+gap-i));
            }

        }

        return ret.toString();
    }
}
