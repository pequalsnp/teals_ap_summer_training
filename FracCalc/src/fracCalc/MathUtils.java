package fracCalc;

class MathUtils {
  static int gcd(int a, int b) {
	  return b==0 ? a : gcd(b, a%b);
  }
  
  static int lcm(int a, int b)
  {
      return a * (b / gcd(a, b));
  }
}
