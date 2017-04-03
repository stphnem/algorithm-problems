/*
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/#/description
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
    	if (points.length == 0 || points == null) {
    		return 0;
    	}

    	Arrays.sort(points, new Comparator<int[]>(){
    		public int compare(int[] p1, int[] p2) {
    			return Integer.compare(p1[1], p2[1]);
    		}
    	});

    	int currentEnd = points[0][1];
    	int count = 1;
    	for (int i=1; i < points.length; i++) {
    		if (points[i][0] > currentEnd) {
    			count++;
    			currentEnd = points[i][1];
    		}
    	}

    	return count;
    }
}