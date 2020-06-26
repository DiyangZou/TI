package LeetCode30May;

public class FindComplement {
	public int findComplement(int num) {
//		int mask = (Integer.highestOneBit(num) << 1) - 1;
//        return num ^ mask;
        
        int r = num;
        int bit = 1;
        while(num != 0) {
            r ^= bit;
            bit <<= 1;
            num >>= 1;
            //System.out.println(num);
            System.out.println(r);
        }
        
        return r;
    }
	
	public static void main(String[] args) {
		FindComplement f = new FindComplement();
		System.out.println(f.findComplement(5));
	}
}
