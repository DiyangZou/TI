package Easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	public int numUniqueEmails(String[] emails) {

		Set<String> set = new HashSet<>();
		for (String e : emails) {
			char[] ch = e.toCharArray();
			int n = ch.length;
			StringBuilder sb = new StringBuilder();
			boolean domain = false;
			for (int i = 0; i < n; ++i) {
				if(ch[i] == '@') domain = true;
				if (domain) {
					sb.append(ch[i]);
				} else {
					if (ch[i] == '.') {
						continue;
					} else if (ch[i] == '+') {
						while (ch[i] != '@') {
							i++;
						}
						domain = true;
					}
					sb.append(ch[i]);
				}
			}
			set.add(sb.toString());
		}
		return set.size();

	}
	public static void main(String[] args) {
		UniqueEmailAddresses s = new UniqueEmailAddresses();
		s.numUniqueEmails(new String[] {"test.email+alex@leetcode.com", "test.email@leetcode.com"});
	}
}
