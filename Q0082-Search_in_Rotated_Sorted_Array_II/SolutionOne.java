class SolutionOne {
    public boolean search(int[] nums, int target) {
        int rs = -1;
        if(nums.length == 0)
            return rs !=  -1;
        // find pivot
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                int[] l = new int[i + 1];
                int[] s = new int[nums.length - i - 1];
                l = Arrays.copyOfRange(nums, 0, i+1);
                s = Arrays.copyOfRange(nums, i + 1, nums.length);
                if(target >= l[0]) {
                    return bs(l,target) != -1;
                } else {
                    return bs(s, target) != -1;
                }
            }
        }
        // array not rotated
        return bs(nums, target) != -1;
    }

    private int bs(int[] array, int target) {
        int first  = 0;
        int last   = array.length - 1;
        int middle = (first + last)/2;

        while( first <= last )
        {
            if ( array[middle] < target )
                first = middle + 1;
            else if ( array[middle] == target )
                return middle;
            else
                last = middle - 1;

            middle = (first + last)/2;
        }
        //if ( first > last )
        return -1;
    }
}
