package problems.algo.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/employee-free-time/
 */

//LeetCode accepted Solution
public class EmployeeFreeTime {

    public class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1);
        }
    }
    
    public int[][] employeeFreeTime(int[][][] schedule) {
        
        //flatten
        List<int[]>  fList = flatten(schedule);
        
        //sort by start time
        Collections.sort(fList, new IntervalComparator());
        
        //merge and get free time
        LinkedList<int[]> mergedList = new LinkedList<int[]>();
        List<int[]> freeList = new ArrayList<int[]>();
        for (int [] i : fList) {
            
            if(mergedList.isEmpty()) {
                mergedList.add(i);
                // //add initial interval to free list if applicable
                // if(i[0] > 0) 
            } else if (mergedList.getLast()[1] < i[0]) {
                //get free time
                freeList.add(new int[]{mergedList.getLast()[1], i[0]});
                //add interval to merged list
                mergedList.add(i);
            } else {
                //merge interval
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], i[1]);
            }
        }
        
        int[][] res = new int[freeList.size()][2];
        return freeList.toArray(res);
    }
    
    private List<int[]> flatten(int[][][] schedule) {
        
        List<int[]> flatSchedule = new ArrayList<int[]>();
        for (int[][] i : schedule) {
            for (int[] j : i) {
                flatSchedule.add(j);
            } 
        }
        
        return flatSchedule;
    }
	public static void main(String[] args) {
		EmployeeFreeTime e = new EmployeeFreeTime();
		int[][][] schedules = new int [][][] {{{1,2},{5,6}},{{1,3}},{{4,10}}};
		System.out.println(e.employeeFreeTime(schedules));
		System.out.println();

	}

}
