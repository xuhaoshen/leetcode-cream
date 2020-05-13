package algorithm.stack.leetcode_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if(top != map.get(c)) {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValid("{{}[]}");


    }
}