/**
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/#/description
 * 
 */

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbors = 0;
        int rows = grid.length, cols = grid[0].length;
        
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (j < cols - 1 && grid[i][j+1] == 1) neighbors++;
                    if (i < rows - 1 && grid[i+1][j] == 1) neighbors++;
                }
            }
        }
        
        return islands * 4 - neighbors * 2;
    }
}