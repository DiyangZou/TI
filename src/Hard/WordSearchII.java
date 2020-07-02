package Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	
	int[][] dirs = new int[][] {{0,1}, {0,-1}, {-1,0}, {1,0}};
	
	public List<String> findWords(char[][] board, String[] words) {
		TrieNode root = buildDict(words);
		int m = board.length, n = board[0].length;
		Set<String> set = new HashSet<>();
		
		boolean [][] visited = new boolean[m][n];
		StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < m; i++){
	      for(int j = 0; j < n; j++){
	        helper(board, visited, set, root, sb, i, j);
	      }
	    }
	    return new ArrayList<>(set);
	}
	
	private TrieNode buildDict(String[] words) {
		TrieNode node = new TrieNode();
		for(String word: words) {
			TrieNode cur = node;
			char[] w = word.toCharArray();
			for(int i = 0; i < w.length; i++) {
				TrieNode next = cur.children[w[i] - 'a'];
				if(next == null) {
					next = new TrieNode();
					cur.children[w[i] - 'a'] = next;
				}
				cur = next;
			}
			cur.isWord = true;
		}
		return node;
	}
	
	private void helper(char[][] board, boolean[][] visited, Set<String> set, TrieNode root, StringBuilder sb, int x, int y) {
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) return;
		char cur = board[x][y];
		if(root.children[cur - 'a'] == null) {
			return;
		}
		sb.append(cur);
		root = root.children[cur - 'a'];
		if(root.isWord) {
			set.add(sb.toString());
		}
		visited[x][y] = true;
		for(int[] d: dirs) {
			int dx = x + d[0];
			int dy = y + d[1];
			helper(board, visited, set, root, sb, dx, dy);
		}
		visited[x][y] = false;
		sb.deleteCharAt(sb.length() - 1);
	}
	
	
	class TrieNode{
		TrieNode[] children = new TrieNode[26];
		boolean isWord;
		
	}
	
	
}
