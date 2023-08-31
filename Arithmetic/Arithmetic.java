import java.io.*; 
import java.util.*; 
public class Arithmetic {

	static Scanner scan; 
	public static int evaluate (String exp) {
		exp = convertClassicToStout(exp); 
		return evaluateStout(exp); 
		
	}
	
	public static int operate (int operand1, int operand2, String operation) {
		if (operation.equals("+")) {
			return operand1 + operand2; 
		}
		if (operation.equals("-")) {
			return operand1 - operand2; 
		}
		if (operation.equals("*")) {
			return operand1 * operand2; 
		}
		if (operation.equals("/")) {
			return operand1 / operand2; 
		}
		return 0; 
		
	}
	
	public static int evaluateStout(String exp) {
		Stack s = new Stack(); 
		scan = new Scanner(exp); 

		
		for (int i = 0; i < exp.length(); i++) {
			
			if (scan.hasNext()) {
				if (scan.hasNextInt()) {
					s.push(scan.nextInt()); 
				}
				else {
					s.push(scan.next());
				}
			}
			if (s.peek().equals("+") ||
				s.peek().equals("-") ||
				s.peek().equals("*") ||
				s.peek().equals("/"))
				{
					String op = (String)(s.pop());
			        int op2 = (int)(s.pop());
			        int op1 = (int)(s.pop());
			        int result = operate(op1,op2,op);
			        s.push(result);
				}
			
		}
		
		return (int)(s.pop()); 
	}
	
	public static String convertClassicToStout(String exp) {
		String answer = ""; 
		scan = new Scanner(exp); 
		
		Stack s = new Stack(); 
		for (int i = 0; i < exp.length(); i++) {
			if (!scan.hasNext()) {
				break; 
			}
			if (scan.hasNextInt()) { 
				answer += scan.nextInt(); 
				answer += " "; 
			}
			else {
				String temp = scan.next(); 
				if (temp.equals("(")) {
					s.push(temp); 
				}
				else if (temp.equals(")")) {
					while (!s.peek().equals("(")) {
						answer += s.pop(); 
						answer += " "; 
					}
					s.pop(); 
				}
				else {
					s.push(temp); 
				}
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder(answer);
		// Remove the last character
		sb.deleteCharAt(sb.length() - 1);
		// Convert the StringBuilder back to a String
		answer = sb.toString();
		return answer; 
	}
}