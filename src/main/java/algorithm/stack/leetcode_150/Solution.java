package algorithm.stack.leetcode_150;

import java.util.Stack;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if("+".equals(curr) || "-".equals(curr) || "*".equals(curr) || "/".equals(curr)) {
                int res;
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (curr) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    default:
                        res = num2 / num1;
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(res);
    }
}