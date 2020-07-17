package Easy;

public class AngleBetweenHandsofaClock {

	public double angleClock(int hour, int minutes) {
        
		double minuteAngle = minutes * 6;
        double hourAngle = hour * 30;
        hourAngle = hourAngle + (minutes * 0.5);
		
        double diff1 = 360 - Math.abs(minuteAngle - hourAngle);
        double diff2 = Math.abs(minuteAngle - hourAngle);

        return Math.min(diff1, diff2);
		
    }
	
	public static void main(String[] args) {
		AngleBetweenHandsofaClock s = new AngleBetweenHandsofaClock();
		s.angleClock(6, 57);
	}
}
