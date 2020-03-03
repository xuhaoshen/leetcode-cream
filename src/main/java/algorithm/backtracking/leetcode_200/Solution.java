package algorithm.backtracking.leetcode_200;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int width,height;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        height = grid.length;
        if(height == 0) return 0;
        width = grid[0].length;
        visited = new boolean[height][width];
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int startX, int startY) {
        visited[startX][startY] = true;
        for(int i = 0; i < 4; i++) {
            int newX = startX + d[i][0];
            int newY = startY + d[i][1];
            if(inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board =
                {};
        int result = solution.numIslands(board);
        System.out.println(result);
    }
}
