package fracCalc;

public class InvalidExpressionException extends Exception {
  public InvalidExpressionException(String expression) {
	  super("Invalid expression " + expression);
  }
}
