package problems.algo.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	 static {
		 map.put('I',1);
		 map.put('X',10);
		 map.put('C',100);
		 map.put('M',1000);
		 map.put('V',5);
		 map.put('L',50);
		 map.put('D',500);

	 }
	
	    public static int rtoi(String num)
	    {       
	        int intNum=0;
	        int prev = 0;
	        for(int i = num.length()-1; i>=0 ; i--)
	        {
	                int temp = map.get(num.charAt(i));
	                if(temp < prev)
	                    intNum-=temp;
	                else
	                    intNum+=temp;
	                prev = temp;
	        }
	        return intNum;
	    }   


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rtoi("MCMXCIV"));

	}

}
