class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Min heap to store the end times
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        }
                );

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                }
        );

        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // if a meeting ends before this meeting, the room is free
            if (intervals[i][0] >= allocator.peek())
                allocator.poll();

            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}