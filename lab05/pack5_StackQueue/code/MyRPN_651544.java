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
        MyStackA stack = new MyStackA();
        String[] tokens = postfixString.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = omegaSwitch(token, operand1, operand2);
                stack.push(result);
            }
        }

        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            System.out.println("Invalid postfix expression");
            return Double.NaN;
        }
    }

    private static double omegaSwitch(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    System.out.println("Division by zero");
                    return Double.NaN;
                }
			case "%":
				if (operand2 != 0) {
					return operand1 % operand2;
				} else {
					System.out.println("Modulation by zero");
					return Double.NaN;
				}
			case "^":
				return Math.pow(operand1, operand2);
            default:
				if (operator.length() >= 1) {
                	System.out.println("Illegal operator: " + operator);
				}
				//so this wouldn't show up when input is empty :>
				return Double.NaN;
        }
    }

	@Override
    public String toString() {
        return "MyRPN class for evaluating postfix expressions";
    }
}
