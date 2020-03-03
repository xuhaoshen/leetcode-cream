package algorithm.backtracking.leetcode_51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<List<String>>(n);
        int[] result = new int[n];
        cal8queens(0, n, result, list);
        return list;
    }

    public void cal8queens(int row, int n, int[] result, List<List<String>> list) {
        if(row == n) {
            list.add(printQueens(result, n));
            return;
        }
        for(int column = 0; column < n; column++) {
            if(isOk(row, column, n, result)) {
                result[row] = column;
                cal8queens(row + 1, n, result, list);
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

    private List<String> printQueens(int[] result, int n) {
        List<String> list = new ArrayList<String>();
        for (int row = 0; row < n; ++row) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int column = 0; column < n; ++column) {
                if (result[row] == column) {
                    stringBuffer.append("Q");
                    System.out.print("Q ");
                }
                else {
                    stringBuffer.append(".");
                    System.out.print(". ");
                }
            }
            list.add(stringBuffer.toString());
            System.out.println();
        }
        System.out.println();
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(8);
    }
}
