package Medium;

public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
	public int numSteps(String s) {
		int res = 0, carry = 0;
	    for (int i = s.length() - 1; i > 0; --i) {
	        ++res;
	        if (s.charAt(i) - '0' + carry == 1) {
	            carry = 1;
	            ++res;
	        }
	    }
	    return res + carry;
	}
	
	public static void main(String[] args) {
		NumberofStepstoReduceaNumberinBinaryRepresentationtoOne s = new NumberofStepstoReduceaNumberinBinaryRepresentationtoOne();
		s.numSteps("0011");
	}
}
