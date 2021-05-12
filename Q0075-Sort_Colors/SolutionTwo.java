class SolutionTwo {
    public void sortColors(int[] A) {
        int i = -1;
        int j = -1;
        int k = -1;
        for(int p = 0; p < A.length; p ++)
        {
            if(A[p] == 0)
            {
                A[++k] = 2;    //move 2 backward
                A[++j] = 1;    //move 1 backward
                A[++i] = 0;    //move 0 backward
            }
            else if(A[p] == 1)
            {
                A[++k] = 2;
                A[++j] = 1;
            }
            else
                A[++k] = 2;
        }
    }
}
