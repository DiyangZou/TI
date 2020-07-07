package Easy;

public class IslandPerimeter {
	int[][] dirs = new int[][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
	public int islandPerimeter(int[][] grid) {
		
		int m = grid.length, n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int[] result = new int[] {0};
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && grid[i][j] == 1) {
					helper(result, grid, visited, i, j, m, n);
					break;
				}else {
					visited[i][j] = true;
				}
			}
		}
		return result[0];
	}
	
	private void helper(int[] result, int[][] g, boolean[][] v, int x, int y, int m, int n) {
		if(x < 0 || x >= m || y < 0 || y >= n || g[x][y] == 0) {
			result[0]++;
			return;
		}
		if(v[x][y]) return;
		v[x][y] = true;
		for(int[] d: dirs) {
			int dx = d[0] + x, dy = d[1] + y;
			helper(result, g, v, dx, dy, m, n);
		}
	}
	
	/*int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0)
                    continue;
                if(i==0 || grid[i-1][j]==0) perimeter++;
                if(i==n-1 || grid[i+1][j]==0) perimeter++;
                if(j==0 || grid[i][j-1]==0) perimeter++;
                if(j==m-1 || grid[i][j+1]==0) perimeter++;
            }
        return perimeter;*/
	
}
