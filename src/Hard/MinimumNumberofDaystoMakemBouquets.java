package Hard;

public class MinimumNumberofDaystoMakemBouquets {
	
	public int minDays(int[] bloomDay, int m, int k) {
		if(m * k > bloomDay.length) return -1;
		int n = bloomDay.length, left = 1, right = (int)1e9;
		
		while(left < right) {
			int mid = left + (right - left) / 2, f = 0, b = 0;
			for(int i = 0; i < n; i++) {
				if(bloomDay[i] > mid) {
					f= 0;
				}else if(++f >= k) {
					b++;
					f = 0;
				}
			}
			if(b < m) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return left;
    }
	
	public static void main(String[] args) {
		MinimumNumberofDaystoMakemBouquets s = new MinimumNumberofDaystoMakemBouquets();
		System.out.println(s.minDays(new int[] {1,10,2,9,3,8,4,7,5,6}, 4, 2));
	}

}
