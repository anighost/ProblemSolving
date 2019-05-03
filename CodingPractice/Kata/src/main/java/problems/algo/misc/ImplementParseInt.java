package problems.algo.misc;

public class ImplementParseInt {

	public static int parseInt(String s) throws NumberFormatException{
		
		boolean isNegativeFound = false;
		int ret = 0;
		int len = s.length();
		
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i) ;
			int charAscii = (int)c;
			if(i == 0 && (int)c == (int)'-') {
				isNegativeFound = true;
			} else {
				if (charAscii < (int)'0' || charAscii > (int)'9') {
					throw new NumberFormatException("Invalid Number : "+s);
				}
				
				int num = charAscii - (int)'0';
				ret = ret *10 + num;
			}
		}
		
		return isNegativeFound? ret*-1 : ret;
		
	}
	public static void main(String[] args) {
		System.out.println(parseInt("998"));
		System.out.println(parseInt("-110011"));
//		System.out.println(parseInt("-110-011"));
//		System.out.println(parseInt("110011-"));
//		System.out.println(parseInt("12AB12"));

	}

}
