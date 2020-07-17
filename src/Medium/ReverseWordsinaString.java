package Medium;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if(s == null) return s;
		char[] ch = s.toCharArray();
		reverseStr(ch, 0, ch.length - 1);
		reversWords(ch);
		return cleanSpace(ch);
	}
	
	private void reverseStr(char[] ch, int start, int end) {
		while(start < end) {
			char tmp = ch[start];
			ch[start++] = ch[end];
			ch[end--] = tmp;
		}
	}
	
	private void reversWords(char[] ch) {
		int i = 0, j = 0, n = ch.length;
		while(i < n) {
			while(i<j) i++;
			while(i < j || i < n && ch[i] == ' ') i++;
			while(j < i || j < n && ch[j] != ' ') j++;
			reverseStr(ch, i, j - 1);
		}
	}
	
	private String cleanSpace(char[] ch) {
		int n = ch.length, i = 0, j = 0;
		while(j < n) {
			while(j < n && ch[j] == ' ') j++;
			while(j < n && ch[j] != ' ') ch[i++] = ch[j++];
			while(j < n && ch[j] == ' ') j++;
			if(j < n) ch[i++] = ' ';
		}
		return new String(ch).substring(0, i);
		
	}
}
