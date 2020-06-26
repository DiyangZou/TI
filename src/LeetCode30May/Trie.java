package LeetCode30May;

public class Trie {
	private TrieNode root;
	
	/** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode();
    	root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode cur = root;
    	char[] chs = word.toCharArray();
    	
    	for(int i = 0; i < chs.length; i++) {
    		int idx = chs[i] - 'a';
    		if(cur.children[idx] == null) {
    			TrieNode node = new TrieNode();
    			node.val = chs[i];
    			cur.children[idx] = node;
    		}
    		cur = cur.children[idx];
    	}
    	cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        
        for(int i = 0; i < chs.length; i++) {
        	int idx = chs[i] - 'a';
        	if(cur.children[idx] == null) {
        		return false;
        	}
        	cur = cur.children[idx];
        }
        if(cur.isWord) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
        char[] chs = prefix.toCharArray();
        
        for(int i = 0; i < chs.length; i++) {
        	int idx = chs[i] - 'a';
        	if(cur.children[idx] == null) {
        		return false;
        	}
        	cur = cur.children[idx];
        }
        return true;
    }

}
class TrieNode{
	public char val;
	public boolean isWord;
	public TrieNode[] children = new TrieNode[26];
}
