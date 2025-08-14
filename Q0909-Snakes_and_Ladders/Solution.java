class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int[] arr=new int[n*n+1];
        boolean lr=true;
        int idx=1;

        for(int i=n-1;i>=0;i--) {
            if(lr) {
                for(int j=0;j<n;j++) arr[idx++]=board[i][j];
            } else {
                for(int j=n-1;j>=0;j--) arr[idx++]=board[i][j];
            }
            lr=!lr;
        }

        boolean[] vis=new boolean[n*n+1];
        Queue<Integer> que=new LinkedList<>();
        que.offer(1);
        vis[1]=true;
        int res=0;
        while(!que.isEmpty()) {
            int size=que.size();
            for(int k=0;k<size;k++) {
                int cur=que.poll();
                if(cur==n*n) return res;

                for(int i=cur+1;i<=Math.min(cur+6,n*n);i++) {
                    int d=arr[i]==-1 ? i : arr[i];
                    if(!vis[d]) {
                        vis[d]=true;
                        que.offer(d);
                    }
                }
            }
            res++;
        }

        return -1;
    }
}