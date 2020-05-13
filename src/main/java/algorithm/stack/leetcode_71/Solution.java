package algorithm.stack.leetcode_71;

import java.util.Stack;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for(String s: str) {
            if("..".equals(s)) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(!"".equals(s) && !".".equals(s)) {
                stack.push(s);
            }
        }
        if(stack.isEmpty()) {
            return "/";
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.simplifyPath("/home//foo/");
        System.out.println(res);


    }
}