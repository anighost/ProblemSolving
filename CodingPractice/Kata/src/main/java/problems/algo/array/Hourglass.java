package problems.algo.array;

public class Hourglass {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr.length; j++) {
                if(i < arr.length - 2 && j < arr.length - 2) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                    + arr[i+1][j+1]
                    + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                    
                    if(sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }

}
