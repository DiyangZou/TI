package Medium;

public class WordDictionary {
	TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        buildDict(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        return helperSearch(root, w, 0);
    }
    
    private void buildDict(String word){
        char[] w = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < w.length; ++i){
            char ch = w[i];
            if(cur.children[ch - 'a'] == null){
            	cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }
    
    private boolean helperSearch(TrieNode curNode, char[] w, int idx){
        if(idx >= w.length){
            if(curNode.isWord) return true;
            return false;
        }
        TrieNode cur = curNode;  
        if(w[idx] == '.'){
            for(TrieNode node: cur.children){
                if(node != null){
                    cur = node;
                    if(helperSearch(cur, w, idx + 1)) return true;
                    cur = curNode;
                }
            }
        }else{
            if(cur.children[w[idx] - 'a'] != null){
                cur = cur.children[w[idx] - 'a'];
                if(helperSearch(cur, w, idx + 1)) return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	WordDictionary s = new WordDictionary();
    	s.addWord("bad");
    	s.addWord("dad");
    	s.addWord("mad");
    	s.search("bad");
    	s.search(".ad");
    	s.search("b..");
	}
}
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
}
