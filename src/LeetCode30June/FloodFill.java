package LeetCode30June;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null) return image;
        
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int color = image[sr][sc];
        q.offer(new int[]{sr, sc});
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] d: dir){
                    int x = d[0] + cur[0];
                    int y = d[1] + cur[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && color == image[x][y]){
                        q.offer(new int[]{x, y});
                    }
                }
                image[cur[0]][cur[1]] = newColor;
            }
        }
        return image;
    }
    public static void main(String[] args) {
    	FloodFill f = new FloodFill();
    	f.floodFill(new int[][] {{1, 1, 1},  {1,1,0},{1, 0, 1}}, 1, 1, 2);
	}
}
