package algorithm.dijkstra;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {
    
    public static void main(String[] args) {
        int MAX = Integer.MAX_VALUE;
        int[][] weight= {
                {0, MAX, 10, MAX, 30, 100},
                {MAX, 0, 5, MAX, MAX, MAX},
                {MAX, MAX, 0, 50, MAX, MAX},
                {MAX, MAX, MAX, 0, MAX, 10},
                {MAX, MAX, MAX, 20, 0, 60},
                {MAX, MAX, MAX, MAX, MAX, 0}
        };
        char[] vertex = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        Dijkstra dijkstra = new Dijkstra(weight, vertex);
        dijkstra.dijkstra(0);
    }
}
