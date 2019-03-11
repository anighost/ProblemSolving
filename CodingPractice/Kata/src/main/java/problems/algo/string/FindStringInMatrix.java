package problems.algo.string;

public class FindStringInMatrix {
	
	public int[][] m_Solution;
	public int m_Path = 1;
	
	public boolean findString(char[][] matrix, String str) {
		boolean findString = false;
		m_Solution = new int[matrix.length][matrix.length];
		
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				//TODO
				if( search(i,j,matrix,str,0)) {
					return true;
				}
			}
		}
		
		return findString;
	}

	private boolean search(int row, int col, char[][] matrix, String str, int k) {
		//Check if kth char of str matches with matrix[i][j]
		//if yes traverse all direction and find match for next char
		//if no return false
		
		if (matrix[row][col] != str.charAt(k) || m_Solution[row][col] > 0) {
			return false;
		}
		
		//Found
		if(k == str.length() - 1) {
			m_Solution[row][col] = m_Path++;
			return true;
		}

		//Mark Current Cell in Solution Matrix
		m_Solution[row][col] = m_Path++;

		//check horizontal right
		if(col+1 < matrix.length && search(row, col+1, matrix, str, k+1)) {
			return true;
		}

		//check horizontal left
		if(col-1 >=0 && search(row, col-1, matrix, str, k+1)) {
			return true;
		}
		
		//check vertical up
		if(row-1 >=0 && search(row-1, col, matrix, str, k+1)) {
			return true; 
		}
		
		//check vertical down
		if(row+1 < matrix.length && search(row+1, col, matrix, str, k+1)) {
			return true;
		}
		
		//check diagonal right up
		if(row-1 >= 0 && col+1 < matrix.length && search(row-1, col+1, matrix, str, k+1)) {
			return true;
		}
		
		//check diagonal right down
		if(row+1 < matrix.length && col+1 < matrix.length && search(row+1, col+1, matrix, str, k+1)) {
			return true;
		}

		//check diagonal left up
		if(row-1 >= 0 && col-1 >= 0 && search(row-1, col-1, matrix, str, k+1)) {
			return true;
		}
		
		//check diagonal left down
		if(row+1 < matrix.length && col-1 >=0 && search(row+1, col-1, matrix, str, k+1)) {
			return true;	
		}
		
		//BakcTrack and reset Solution Matrix
		m_Solution[row][col] = 0;
		m_Path--;
			
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = 
			{ 
					{ 't', 'z', 'x', 'c', 'd' },
					{ 'a', 'h', 'n', 'z', 'x' }, 
					{ 'h', 'w', 'o', 'i', 'o' },				
					{ 'o', 'r', 'n', 'r', 'n' }, 
					{ 'a', 'b', 'r', 'i', 'n' } 
					};
		FindStringInMatrix f = new FindStringInMatrix();
		System.out.println(f.findString(matrix, "horizon"));
		System.out.println(f.findString(matrix, "horn"));
		System.out.println(f.findString(matrix, "bond"));
		System.out.println(f.findString(matrix, "xox"));

	}

}
