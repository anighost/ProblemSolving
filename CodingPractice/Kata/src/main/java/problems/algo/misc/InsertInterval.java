package problems.algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

	You may assume that the intervals were initially sorted according to their start times.

	Example 1:

	Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
	Output: [[1,5],[6,9]]
 */
public class InsertInterval {

	public class IntervalComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] < o2[0] ? -1 : (o1[0] == o2[0] ? 0 : 1);
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {

		int [][] allIntervals = new int [intervals.length+1][2];
		if(intervals.length == 0) {
			allIntervals[0] = newInterval;
			return allIntervals;
		}
		int i = 0;
		while ( i < intervals.length) {
			allIntervals[i] = intervals[i];
			i++;
		}


		allIntervals[i] = newInterval;
		Arrays.sort(allIntervals, new IntervalComparator());

		LinkedList<int[]> mergedList = new LinkedList<int[]>();

		for (int [] interval : allIntervals) {

			//check if list is empty
			if (mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]) {
				mergedList.add(interval);
			} else {
				mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
			}
		}

		int [][] result = new int [mergedList.size()][2];
		return mergedList.toArray(result);
	}

	public int[][] insertOptimized(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<int[]>();
		
		int i = 0;
		//keep on adding intervals as long as interval.end < newinterval.start
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			list.add(intervals[i++]);
		}
		
		//check if reached end of intervals
		//if not, merge newinterval
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			int[] curr = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
			newInterval = curr;
			i++;
		}
		//add merged interval
		list.add(newInterval);
		
		//add rest of intervals
        while(i < intervals.length){
            list.add(intervals[i++]);
        }
        
        int[][] insert = new int[list.size()][2];
        for(int j = 0; j < list.size(); j++){
            insert[j] = list.get(j);
        }
        return insert;
	}

	private static void printArray(int[][] nums) {
		System.out.println("");
		for (int i = 0; i < nums.length; i++) {
			System.out.print("["+nums[i][0]+","+nums[i][1]+"] ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval i = new InsertInterval();
		int [][] intervals = new int[][] {{1,3},{6,9}};
		int [] interval = new int [] {2,5};
		printArray(i.insert(intervals, interval));
		printArray(i.insertOptimized(intervals, interval));

	}

}
