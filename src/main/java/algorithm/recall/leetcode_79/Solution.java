package algorithm.recall.leetcode_79;

import java.util.BitSet;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int width,height;
    BitSet[] visited;

    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        visited = new BitSet[height];
        for(int i = 0; i < visited.length; i++) {
            visited[i] = new BitSet();
        }
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if(index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if(board[startX][startY] == word.charAt(index)) {
            visited[startX].set(startY, true);
            for(int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if(inArea(newX, newY) && !visited[newX].get(newY)) {
                    if(searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            visited[startX].set(startY, false);
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board =
                {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean result = solution.exist(board, "ABCB");
        System.out.println(result);
    }
}
