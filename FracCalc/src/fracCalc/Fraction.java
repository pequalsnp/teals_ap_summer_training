package fracCalc;

public class Fraction {
	private int _numerator;
	private int _denominator;
	
	public Fraction(int numerator, int denominator) {
		_numerator = numerator;
		_denominator = denominator;
		reduce();
	}
	
	private void setNumeratorDenominator(String fraction) {
		String[] tokens = fraction.split("/");
		_numerator = Integer.parseInt(tokens[0]);
		_denominator = Integer.parseInt(tokens[1]);
	}
	
	public Fraction(String stringFraction) {
		if (stringFraction.contains("_")) {
			String[] tokens = stringFraction.split("_");
			int wholePortion = Integer.parseInt(tokens[0]);
			setNumeratorDenominator(tokens[1]);
			if (wholePortion >= 0) {
				_numerator += _denominator * wholePortion;
			} else {
				_numerator = -_numerator - (_denominator * -wholePortion);
			}
		} else if (stringFraction.contains("/")) {
			setNumeratorDenominator(stringFraction);
		} else {
			_numerator = Integer.parseInt(stringFraction);
			_denominator = 1;
		}
		reduce();
	}
	
	public void reduce() {
		if ((_numerator < 0 && _denominator < 0) || _denominator < 0) {
			_numerator = -_numerator;
			_denominator = -_denominator;
		}
		int gcd = MathUtils.gcd(Math.abs(_numerator), Math.abs(_denominator));
		_numerator /= gcd;
		_denominator /= gcd;
	}
	
	public int getNumerator() {
		return _numerator;
	}
	
	public int getDenominator() {
		return _denominator;
	}
	
	public String toString() {
		if (_numerator == 0) {
			return "0";
		}
		int wholePortion = _numerator / _denominator;
		if (wholePortion != 0) {
			int numerator = Math.abs(_numerator) - (Math.abs(wholePortion) * _denominator);
			if (numerator == 0) {
				return wholePortion + "";
			} else {
				return wholePortion + "_" + numerator + "/" + _denominator;
			}
		} else {
			return _numerator + "/" + _denominator;
		}
	}
}
