class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0) return res;
        int top = 0, bot = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int i = 0, j = 0;
        boolean gotop = true, gobot = false, goleft = false, goright = false;

        while(top <= bot && left <= right) {
            //System.out.println(matrix[i][j]);
            res.add(matrix[i][j]);
            if(gotop) {
                if(j == right) {
                    gotop = false;
                    goright = true;
                    top++;
                    i++;
                } else
                    j++;

            } else if(goright){
                if(i == bot) {
                    goright = false;
                    gobot = true;
                    right--;
                    j--;
                } else
                    i++;

            } else if(gobot) {
                if(j == left) {
                    gobot = false;
                    goleft = true;
                    bot--;
                    i--;
                } else
                    j--;;

            } else {
                if(i == top) {
                    goleft = false;
                    gotop = true;
                    left++;
                    j++;
                } else
                    i--;
            }

        }
        return res;
    }
}
