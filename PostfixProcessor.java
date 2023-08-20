package Midterm;

//parse the input expression string from left to right

//if an operand (i.e. a number) is received, push into stack
//if an operation is received,
//		pop two operands out of stacks, and perform operation
//		then push the result back to the stack
//repeat the process until there is nothing left in the expression

// parse number in while loop
// add number to stack - only numbrs will go into stack
// operations always pop out 2 numbers

public class PostfixProcessor {

	LinkedStack list = new LinkedStack();
	String[] tempArray;

	// overloaded constructor
	public PostfixProcessor(String numbers) {

		// takes string of numbers and splits it into an array
		tempArray = numbers.split(" ");

		for (int i = 0; i < tempArray.length; i++) {
			if (this.validOperation(tempArray[i])) {
				// looks at top of stack and removes
				String firstTop = (String) list.top();
				list.pop();
				String secondTop = (String) list.top();
				list.pop();

				String tempResult = mathStuff(firstTop, secondTop, tempArray[i]);
				list.push(tempResult);
			} else {
				// adds number to the stack
				list.push(tempArray[i]);
			}
		}
	}

	// checks if an operation is received
	public boolean validOperation(String operation) {
		switch (operation) {
		case "+":
		case "-":
		case "*":
		case "/":
			return true;
		default:
			return false;
		}
	}

	// takes 2 numbers (in string format) with the operation and returns the result
	public String mathStuff(String number1, String number2, String operation) {
		int tempValue = 0;
		int num1 = Integer.valueOf(number1);
		int num2 = Integer.valueOf(number2);

		switch (operation) {
		case "+":
			tempValue = num1 + num2;
			break;
		case "-":
			tempValue = num1 - num2;
			break;
		case "*":
			tempValue = num1 * num2;
			break;
		case "/":
			tempValue = num1 / num2;
			break;
		}
		return "" + tempValue;
	}

	// overloaded toString
	public String toString() {
		String temp = "";
		for (int i = 0; i < tempArray.length; i++)
			temp += tempArray[i] + " ";
		temp += "= " + (String) list.top();
		return temp;
	}
}
