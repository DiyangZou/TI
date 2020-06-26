package LeetCode30April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		
		if(strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		
		Map<String, List<String>> map = new HashMap<>();
		for(String s : strs) {
			int[] arr = new int[26];
			for(int i = 0;i<s.length();i++){
                arr[s.charAt(i) - 'a']++;
            }
			String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key,tempList);
		}
		
		return new ArrayList<List<String>>(map.values());

	}
}
