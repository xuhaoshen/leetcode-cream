package algorithm.array.leetcode_345;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowels = "AEIOUaeiou";
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if(vowels.indexOf(chars[i]) != -1 && vowels.indexOf(chars[j]) != -1) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if(vowels.indexOf(chars[i]) == -1) {
                i++;
            } else if(vowels.indexOf(chars[j]) == -1) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String val = solution.reverseVowels("a,.b");
        System.out.println(val);
    }
}
