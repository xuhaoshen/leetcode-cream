package algorithm.dijkstra;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/5/1
 */
public class Dijkstra {

    private boolean[] visited;
    private int MAX = Integer.MAX_VALUE;
    private int[][] matrix;
    private int[] dist;
    private char[] vertex;
    private int size;

    public Dijkstra(int[][] matrix, char[] vertex) {
        this.matrix = matrix;
        this.vertex = vertex;
        this.size = matrix.length;
        this.visited = new boolean[size];
        this.dist = new int[size];
    }

    public void dijkstra(Integer start) {
        for(int i = 0; i < dist.length; i++) {
            dist[i] = matrix[start][i];
        }
        visited[start] = true;
        dist[start] = 0;
        int index = 0;
        for(int i = 0; i < size; i++) {
            int min = MAX;
            for(int j = 0; j < dist.length; j++) {
                if(min > dist[j] && !visited[j]) {
                    index = j;
                    min = dist[j];
                }
            }
            for(int j = 0; j < size; j++) {
                int tmp = (matrix[index][j] == MAX ? MAX : (min + matrix[index][j]));
                if(tmp < dist[j]) {
                    dist[j] = tmp;
                }
            }
            visited[index] = true;
        }

        System.out.printf("dijkstra(%c): \n", vertex[start]);
        for (int i=0; i < matrix.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", vertex[start], vertex[i], dist[i]);
    }

}
