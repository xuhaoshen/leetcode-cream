package algorithm.array.leetcode_76;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        int[] map = new int[256];
        for(int i = 0;i < t.length(); i++){
            map[T[i]]++;
        }
        int winL= 0, winR = 0;
        int matchCount = 0;
        int start = -1;
        int minLength = 0;
        while (winL <= winR && winR < s.length()) {
            map[S[winR]] --;
            if(map[S[winR]] >= 0) {
                matchCount++;
            }
            if(matchCount == t.length()) {
                while (winL <= winR) {
                    if((winR - winL < minLength && start > -1) || start == -1) {
                        minLength = winR - winL;
                        start = winL;
                    }
                    map[S[winL]] ++;
                    if(map[S[winL]] > 0) {
                        matchCount--;
                        winL++;
                        break;
                    }
                    winL++;
                }
            }
            winR++;
        }
        if(start == -1) {
            return "";
        }
        return s.substring(start, start + minLength + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String v = solution.minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println(v);
    }
}
