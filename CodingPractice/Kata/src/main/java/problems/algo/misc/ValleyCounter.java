package problems.algo.misc;

public class ValleyCounter {

	static int countingValleys(int n, String s) {
        int valleyCounter = 0;
        char lastStep = 'Z';
        boolean inValley = false;
        for (int i = 0; i < s.length(); i++) {
            char currStep = s.charAt(i);
            if(currStep == 'D') {
                if (lastStep == currStep) {
                    inValley = true;
                }
            } else {
                if(inValley) {
                    valleyCounter++;
                    inValley = false;
                }
            }

            lastStep = currStep;
        }

        return valleyCounter;
    }
	

	public static void main(String[] args) {
		String s = "DUDDDUUDUU";
		System.out.println(countingValleys(10, s));
		

	}

}
