package problems.algo.array;

public class MoveZeros {

	public void moveZeroes(int[] nums) {

        int lastNonZeroIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                //swap
                int tmp = nums[i];
                nums[i] = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex]  = tmp;
                lastNonZeroIndex++;
            }            
        }   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
