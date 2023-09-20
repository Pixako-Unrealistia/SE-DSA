import code.MyStackA;

import java.util.StringTokenizer;

import code.MyRPN;

class L5_RPN_Main {
    private static void testTokenizer(String toBeRPN) {
        StringTokenizer st = new StringTokenizer(toBeRPN);
        int i = 0;
        String t = "";
        while (st.hasMoreTokens()) {
            t = st.nextToken();
            if (MyRPN.isNumeric(t))
                System.out.println("Token " + i++ + " = " + t);
            else
                System.out.println("Token " + i++ + " = " + t + " is an opearator");
        }
    }
    public static void main(String[] args) { 
        // 3 1 - 4 5 + * -> ans = 18
        //8 5 - 4 2 + 3 / * -> ans = 6
        //2 5 * 4 + 3 2 * 1 + / -> ans = 2
        //String postfixString = "2 5 * 4 + 3 2 * 1 + /";
        String postfixString = "2 5 * 4 + 3 2 * 1 + /";
		if (args.length > 0)
            postfixString = args[0];
        testTokenizer(postfixString);
        System.out.println(postfixString);
        System.out.println("Result = " + MyRPN.computeRPN(postfixString));
    }
}


/*2
5
 

10
4

14
3
2

14
7

2*/