package algorithm.backtracking.leetcode_52;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    int count = 0;
    public int totalNQueens(int n) {
        int[] result = new int[n];
        cal8queens(0, n, result);
        return count;
    }

    public void cal8queens(int row, int n, int[] result) {
        if(row == n) {
            ++count;
            return;
        }
        for(int column = 0; column < n; column++) {
            if(isOk(row, column, n, result)) {
                result[row] = column;
                cal8queens(row + 1, n, result);
            }
        }
    }

    private boolean isOk(int row, int column, int n, int[] result) {
        int leftup = column - 1;
        int rightup = column + 1;
        for(int i = row -1; i >= 0; i--) {
            if(result[i] == column) return false;
            if(leftup >= 0) {
                if(result[i] == leftup) return false;
            }
            if(rightup < n) {
                if(result[i] == rightup) return  false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.totalNQueens(4);
        System.out.println(result);
    }
}
