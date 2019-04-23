package problems.algo.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis1 {
    Map<Character, Character> charMap;
    
    public Parenthesis1() {
        charMap = new HashMap<Character, Character>();
        charMap.put(')','(');
        charMap.put('}','{');
        charMap.put(']','[');
        
    }
    public boolean isValid(String s) {
        
        //{[()]}
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //first time - stack is empty
            if(charMap.get(c) != null) {
                char open = stack.isEmpty()? 'X' : stack.pop();
                if(open != charMap.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
	public static void main(String[] args) {
		Parenthesis1 p = new Parenthesis1();
		System.out.println(p.isValid("()"));

	}

}
