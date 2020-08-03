package Easy;

public class WaterBottles {
	public int numWaterBottles(int numBottles, int numExchange) {
        int result = 0, full = numBottles, empty = 0;
        
        while(full > 0){
            result += full;
            int exchange = (full + empty) / numExchange;
            empty = (full + empty) % numExchange;
            full = exchange;
        }
        return result;
    }
	public static void main(String[] args) {
		WaterBottles s = new WaterBottles();
		s.numWaterBottles(15, 4);
	}
}
