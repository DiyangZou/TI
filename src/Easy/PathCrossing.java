package Easy;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
	public boolean isPathCrossing(String path) {

		int x = 0, y = 0;
		char[] p = path.toCharArray();
		Set<String> seen = new HashSet<>();
        seen.add(0 + ", " + 0);
		for (char d : p) {
			if (d == 'N') {
				y++;
			} else if (d == 'S') {
				y--;
			} else if (d == 'E') {
				x++;
			} else {
				x--;
			}
			if (!seen.add(x + ", " + y)) {
                return true;
            }
		}
		return false;
	}
	
	public static void main(String[] args) {
		PathCrossing s = new PathCrossing();
		System.out.println(s.isPathCrossing("NESWW"));
	}
}
