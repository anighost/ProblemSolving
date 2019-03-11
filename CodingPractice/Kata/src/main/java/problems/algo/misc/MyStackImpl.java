package problems.algo.misc;

/**
 * 
 * Implement stack operations
 *
 */
public class MyStackImpl {
	
	int [] myStack;
	int top;
	
	public MyStackImpl(int s){
		myStack = new int [s];
		top = -1;
	}
	
	public void push(int num) {
		if (!isFull()) {
			myStack[++top] = num;
		} else {
			throw new IllegalArgumentException("Stack is full");
		}
	}
	
	public int pop () {
		if (!isEmpty()) {
			return myStack[top--];
		} else {
			throw new IllegalArgumentException("Stack is empty");
		}
	}
	
	public int peek() {
		if (!isEmpty()) {
			return myStack[top];
		} else {
			throw new IllegalArgumentException("Stack is empty");
		}
	}
	
	public boolean isEmpty() {
		if (top < 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		
		if (myStack.length == top+1) {
			return true;
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) {
	      MyStackImpl theStack = new MyStackImpl(10); 
	      theStack.push(10);
	      theStack.push(20);
	      theStack.push(30);
	      theStack.push(40);
	      theStack.push(50);
	      
	      while (!theStack.isEmpty()) {
	         long value = theStack.pop();
	         System.out.print(value);
	         System.out.print(" ");
	      }
	      System.out.println("");

	}

}
