class Solution {
    public String reverseWords(String s) {

        String[] arr = s.split(" +");;
        StringBuilder sb = new StringBuilder();
        for(int i= arr.length-1;i>=0;i--){
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
/*
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        for (int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ') continue;
            int end = start;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            res.append(s.substring(start + 1, end + 1)).append(" ");
        }
        return res.toString().trim();
    }
}
*/