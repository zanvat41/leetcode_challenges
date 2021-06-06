class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        // basic idea:
        // Choose the station as starting point.
        // Perform the road trip and check how much gas we have in tank at each station.
        int gasSum = 0;
        int costSum = 0;
        for(int j = 0; j < gas.length; j++) {
            for(int i = 0; i < gas.length; i++) {
                gasSum += gas[(i + j) % gas.length];
                costSum += cost[(i + j) % gas.length];
                if(gasSum < costSum){
                    gasSum = 0;
                    costSum = 0;
                    break;
                }
                if(i == gas.length - 1)
                    return j;

            }
        }
        return -1;
        */

        // One pass
        int curTank = 0, totalTank = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            curTank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];
            if(curTank < 0){
                start = i + 1;
                curTank = 0;
            }
        }
        return totalTank >= 0 ? start : -1;
    }
}
