package problems.algo.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Play {

	public static void main(String[] args) {
//		String s = "MCMXCIV";
		// M -> 0
		// CM -> 1
		// XC -> 3
		// IV -> 5
		
		//1000*1 + 900*1 + 90 + 4
		
//		String ss1 = "M";
//		String ss2 = "C";
//		String ss3 = "X";
//		String ss4 = "IV";
//		
//		System.out.println(s.indexOf(ss1));
//		System.out.println(s.indexOf(ss2));
//		System.out.println(s.indexOf(ss3));
//		System.out.println(s.indexOf(ss4));
//		System.out.println(s.indexOf("A"));
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		
		System.out.println(list);
		int l = list.size()-1 ;
		list.remove(l);
		System.out.println(list);
		
		System.out.println("HELLO".substring(1,2));
		System.out.println(0^0);
		System.out.println(0^1);
		System.out.println(1^0);
		System.out.println(1^1);
		
		Comparator<Integer> intComp = new 	Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		};
		PriorityQueue<Integer> pq  = new PriorityQueue<Integer>(intComp);
		pq.add(10);
		pq.add(6);
		pq.add(4);
		pq.add(8);
		

        @SuppressWarnings("rawtypes")
		Iterator itr = pq.iterator(); 
        while (itr.hasNext()) 
            System.out.println("queue element : "+itr.next()); 
        
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

	}

}
