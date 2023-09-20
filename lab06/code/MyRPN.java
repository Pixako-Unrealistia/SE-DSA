package code;

import java.util.regex.Pattern;

public class MyRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String postfixString) {
        MyStackL stack = new MyStackL();
        String[] tokens = postfixString.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(token);
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = omegaSwitch(token, operand1, operand2);
                stack.push(result);
            }
        }

        if (!stack.isEmpty()) {
            return Double.parseDouble(stack.pop());
        } else {
            System.out.println("Invalid postfix expression");
            return Double.NaN;
        }
    }

    private static String omegaSwitch(String operator, String operand1, String operand2) {
		double op1 = Double.parseDouble(operand1);
		double op2 = Double.parseDouble(operand2);
		double result = 0;
		switch (operator) {
			case "+":
				result = op1 + op2;
				break;
			case "-":
				result = op1 - op2;
				break;
			case "*":
				result = op1 * op2;
				break;
			case "/":
				if (op2 == 0) {
					System.out.println("Divide by zero error");
					return Double.NaN + "";
				}
				result = op1 / op2;
				break;
			default:
				System.out.println("Invalid operator");
				return Double.NaN + "";
		}
		return result + "";
    }

	@Override
    public String toString() {
        return "MyRPN class for evaluating postfix expressions";
    }
}
