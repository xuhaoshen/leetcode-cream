package algorithm.queue.leetcode_127;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean[] flag = new boolean[wordList.size()];
        int layer = 1;
        while (!queue.isEmpty()) {
            layer++;
            int count = queue.size();
            while (count > 0) {
                String current = queue.poll();
                for(int i = 0; i < wordList.size(); i++) {
                    if(flag[i]) continue;
                    String word = wordList.get(i);
                    if(checked(word, current)) {
                        if(word.equals(endWord)) return layer;
                        queue.add(word);
                        flag[i] = true;
                    }
                }
                count--;

            }
        }
        return 0;
    }

    private boolean checked(String word, String current) {
        int diff = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != current.charAt(i)) diff++;
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("cog");
        int res = solution.ladderLength("hit", "cog", wordList);
        System.out.println(res);

    }
}
