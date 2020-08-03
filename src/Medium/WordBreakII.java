package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
//	public List<String> wordBreak(String s, List<String> wordDict) {
//
//		List<String> result = new ArrayList<>();
//		TrieNode root = buildDict(wordDict);
//		char[] chs = s.toCharArray();
//		helper(result, new ArrayList<String>(), root, chs, 0);
//		return result;
//	}
//
//	private void helper(List<String> result, List<String> tmp, TrieNode root, char[] chs, int idx) {
//		if (idx == chs.length) {
//			String cur = String.join(" ", tmp);
//			result.add(cur);
//			return;
//		}
//
//		for (int i = idx; i < chs.length; i++) {
//			if (search(root, chs, idx, i)) {
//				String find = new String(chs, idx, i - idx + 1);
//				tmp.add(find);
//				helper(result, tmp, root, chs, i + 1);
//				tmp.remove(tmp.size() - 1);
//			}
//		}
//	}
//
//	private boolean search(TrieNode root, char[] chs, int start, int end) {
//		TrieNode node = root;
//		for (int i = start; i <= end; i++) {
//			TrieNode cur = node.children[chs[i] - 'a'];
//			if (cur == null)
//				return false;
//			node = cur;
//		}
//		return node.isWord;
//	}
//
//	private TrieNode buildDict(List<String> words) {
//		TrieNode root = new TrieNode();
//
//		for (String word : words) {
//			TrieNode node = root;
//			char[] cur = word.toCharArray();
//			for (int i = 0; i < cur.length; i++) {
//				TrieNode next = node.children[cur[i] - 'a'];
//				if (next == null) {
//					node.children[cur[i] - 'a'] = new TrieNode();
//					next = node.children[cur[i] - 'a'];
//				}
//				node = next;
//			}
//			node.isWord = true;
//		}
//		return root;
//	}
//
//	class TrieNode {
//		boolean isWord;
//		TrieNode[] children = new TrieNode[26];
//	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet();
        for(String word: wordDict){
            wordDictSet.add(word);        
        }
        return helper(s, new HashMap<String, List<String>>(), wordDictSet);
    }
    private List<String> helper(String str, Map<String, List<String>> map, Set<String> wordDict){
        if(map.containsKey(str))
            return map.get(str);
        List<String> l = new LinkedList<>();
        if(str.length() == 0){
            l.add("");
            return l;
        }
        StringBuilder sb = new StringBuilder();
        for(String word: wordDict){
            if(str.startsWith(word)){
                //sb = new StringBuilder();
                for(String next : helper(str.substring(word.length()), map, wordDict)){
                    sb = new StringBuilder();
                    sb.append(word);
                    if(next.length() > 0)
                        sb.append(" ");
                    sb.append(next);
                    l.add(sb.toString());
                }
            }
        }
        map.put(str, l);
        return l;
    }

	public static void main(String[] args) {
		WordBreakII s = new WordBreakII();
		String[] d = new String[] { "cat", "cats", "and", "sand", "dog" };
		List<String> dict = Arrays.asList(d);
		List<String> result = s.wordBreak("catsanddog", dict);
		
		for(String ss: result) {
			System.out.println(ss);
		}
	}
}
