package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    	System.out.println("Enter the equation: ");
    	Scanner scanner = new Scanner(System.in);
    	String input = scanner.nextLine();
    	scanner.close();
    	System.out.println(produceAnswer(input));
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] tokens = input.split("[ ]+");
    	Fraction lhs = new Fraction(tokens[0]);
    	for (int i = 1; i < tokens.length; i+=2) {
    		Fraction rhs = new Fraction(tokens[i+1]);
    		String op = tokens[i];
    		switch(op) {
				case "+":
					lhs = add(lhs, rhs);
					break;
				case "-":
					lhs = subtract(lhs, rhs);
					break;
				case "*":
					lhs = multiply(lhs, rhs);
					break;
				case "/":
					lhs = divide(lhs, rhs);
					break;
			    default:
			    	break;
    		}
    	}
		
		return lhs.toString();
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static Fraction add(Fraction lhs, Fraction rhs) {
    	int lcm = MathUtils.lcm(lhs.getDenominator(), rhs.getDenominator());
    	int lhsNumerator = lhs.getNumerator() * (lcm / lhs.getDenominator());
    	int rhsNumerator = rhs.getNumerator() * (lcm / rhs.getDenominator());
    	return new Fraction(lhsNumerator + rhsNumerator, lcm);
    }
    
    public static Fraction subtract(Fraction lhs, Fraction rhs) {
    	int lcm = MathUtils.lcm(lhs.getDenominator(), rhs.getDenominator());
    	int lhsNumerator = lhs.getNumerator() * (lcm / lhs.getDenominator());
    	int rhsNumerator = rhs.getNumerator() * (lcm / rhs.getDenominator());
    	return new Fraction(lhsNumerator - rhsNumerator, lcm);
    }
    
    public static Fraction multiply(Fraction lhs, Fraction rhs) {
    	return new Fraction(lhs.getNumerator() * rhs.getNumerator(), lhs.getDenominator() * rhs.getDenominator());
    }
    
    public static Fraction divide(Fraction lhs, Fraction rhs) {
    	return new Fraction(lhs.getNumerator() * rhs.getDenominator(), lhs.getDenominator() * rhs.getNumerator());
    }
    
}
