class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for(int i =0; i<intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        int[] maxp = new int[max+1];
        for(int i=0;i<intervals.length; i++) {
            maxp[intervals[i][0]] = Math.max(intervals[i][1]+1, maxp[intervals[i][0]]); 
        }
        int start = -1;
        int end = -1;
        int size = 0;
        for(int i=0; i<maxp.length; i++) {
            if(maxp[i]!=0) {
                if(start==-1) start = i;
                end = Math.max(end, maxp[i]-1);
            }
            if(end==i) {
                intervals[size++] = new int[] {start, end};
                start = -1;
                end = -1;
            }
        }
        if(start!=-1) {
            intervals[size++] = new int[] {start, end};
        }
        if(intervals.length == size) {
            return intervals;
        }
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            res[i] = intervals[i];
        }

        return res;
    }
}
