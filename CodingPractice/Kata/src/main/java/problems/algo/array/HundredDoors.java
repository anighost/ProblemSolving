package problems.algo.array;

/*
 * you have 100 doors in a row that are all initially closed. 
 * you make 100 passes by the doors starting with the first door every time. 
 * the first time through you visit every door and toggle the door (if the door is closed, you open it, 
 * if its open, you close it). the second time you only visit every 2nd door (door #2, #4, #6). 
 * the third time, every 3rd door (door #3, #6, #9), etc, 
 * until you only visit the 100th door
 */

public class HundredDoors {

	public static void main(String[] args) {
        boolean[] doors = new boolean[101];
        for (int i = 1; i < doors.length; i++) {
        	for (int j = i; j < doors.length; j+= i) {
        		doors[j] = !doors[j];
        	}
        }

        for (int i = 1; i < doors.length; i++) {
            if (doors[i]) {
                System.out.printf("Door %d is open.%n", i);
            }
        }

	}

}
