package problems.algo.backtrack;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., N*N - 1].
 */

public class SwimInRisingWater {
	
	boolean [][] visited;
	int minMax;

	public int swimInWater(int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) ->
                grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
        pq.offer(0);
        int ans = -1;

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int k = pq.poll();
            int r = k / N, c = k % N;
            ans = Math.max(ans, grid[r][c]);
            if (r == N-1 && c == N-1) return ans;

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
                    pq.offer(ck);
                    seen.add(ck);
                }
            }
        }
        
        return ans;
        
	}

	
	public int swimInWaterBad(int[][] grid) {
		visited = new boolean[grid.length][grid[0].length];
		minMax = Integer.MAX_VALUE;
		backtrack(0, 0, grid, Integer.MIN_VALUE);
		
		return minMax;
	}
	
	private boolean isValid(int r, int c, int[][] grid) {
		if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c]) {
			return true;
		}
		
		return false;
	}
	
	private boolean isEnd(int r, int c, int[][] grid) {
		if (r == grid.length-1 && c == grid[0].length -1) {
			return true;
		}
		return false;
	}
	
	private void backtrack(int r, int c, int[][] grid, int prevMax) {
		
		//check if valid grid - if not abandon
		if(!isValid(r, c, grid)) {
			return;
		}
		
		
		//check for max
		int currMax = Math.max(grid[r][c],prevMax);
		//check if reached the end - break
		if (isEnd(r, c, grid) ) {
			minMax = Math.min(currMax, minMax);
			return;
		}
		//set visited
		visited[r][c] = true;
		
		//recursion - 4 directions
		backtrack(r+1, c, grid, currMax);
		backtrack(r-1, c, grid, currMax);
		backtrack(r, c+1, grid, currMax);
		backtrack(r, c-1, grid, currMax);
		
		//backtrack
		visited[r][c] = false;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] grid1 = new int[][] {{0,1},{3,2}};
		SwimInRisingWater s = new SwimInRisingWater();
		System.out.println(s.swimInWater(grid1));
		
		int [][] grid2 = new int [][] {{26,99,80,1,89,86,54,90,47,87},{9,59,61,49,14,55,77,3,83,79},{42,22,15,5,95,38,74,12,92,71},{58,40,64,62,24,85,30,6,96,52},{10,70,57,19,44,27,98,16,25,65},{13,0,76,32,29,45,28,69,53,41},{18,8,21,67,46,36,56,50,51,72},{39,78,48,63,68,91,34,4,11,31},{97,23,60,17,66,37,43,33,84,35},{75,88,82,20,7,73,2,94,93,81}};
		System.out.println(s.swimInWater(grid2));
	}

}
