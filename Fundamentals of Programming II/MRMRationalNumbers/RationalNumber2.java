package MRMRationalNumbers;

//********************************************************************
//RationalNumber2.java       Author: Lewis/Loftus
//
//Solution to Programming Project 7.4
//********************************************************************

public class RationalNumber2 implements Comparable
{
private int numerator, denominator;
private final double TOLERANCE = 0.0001;

//-----------------------------------------------------------------
//  Sets up the rational number by ensuring a nonzero denominator
//  and making only the numerator signed.
//-----------------------------------------------------------------
public RationalNumber2(int numer, int denom)
{
  if (denom == 0)
     denom = 1;

  // Make the numerator "store" the sign
  if (denom < 0)
  {
     numer = numer * -1;
     denom = denom * -1;
  }

  numerator = numer;
  denominator = denom;

  reduce();
}

//-----------------------------------------------------------------
//  Returns the numerator of this rational number.
//-----------------------------------------------------------------
public int getNumerator()
{
  return numerator;
}

//-----------------------------------------------------------------
//  Returns the denominator of this rational number.
//-----------------------------------------------------------------
public int getDenominator()
{
  return denominator;
}

//-----------------------------------------------------------------
//  Returns the reciprocal of this rational number.
//-----------------------------------------------------------------
public RationalNumber2 reciprocal()
{
  return new RationalNumber2(denominator, numerator);
}

//-----------------------------------------------------------------
//  Adds this rational number to the one passed as a parameter.
//  A common denominator is found by multiplying the individual
//  denominators.
//-----------------------------------------------------------------
public RationalNumber2 add(RationalNumber2 op2)
{
  int commonDenominator = denominator * op2.getDenominator();
  int numerator1 = numerator * op2.getDenominator();
  int numerator2 = op2.getNumerator() * denominator;
  int sum = numerator1 + numerator2;

  return new RationalNumber2(sum, commonDenominator);
}

//-----------------------------------------------------------------
//  Subtracts the rational number passed as a parameter from this
//  rational number.
//-----------------------------------------------------------------
public RationalNumber2 subtract(RationalNumber2 op2)
{
  int commonDenominator = denominator * op2.getDenominator();
  int numerator1 = numerator * op2.getDenominator();
  int numerator2 = op2.getNumerator() * denominator;
  int difference = numerator1 - numerator2;

  return new RationalNumber2(difference, commonDenominator);
}

//-----------------------------------------------------------------
//  Multiplies this rational number by the one passed as a
//  parameter.
//-----------------------------------------------------------------
public RationalNumber2 multiply(RationalNumber2 op2)
{
  int numer = numerator * op2.getNumerator();
  int denom = denominator * op2.getDenominator();

  return new RationalNumber2(numer, denom);
}

//-----------------------------------------------------------------
//  Divides this rational number by the one passed as a parameter
//  by multiplying by the reciprocal of the second rational.
//-----------------------------------------------------------------
public RationalNumber2 divide(RationalNumber2 op2)
{
  return multiply(op2.reciprocal());
}

//-----------------------------------------------------------------
//  Determines if this rational number is equal to the one passed
//  as a parameter. Assumes they are both reduced.
//-----------------------------------------------------------------
public boolean isLike(RationalNumber2 op2)
{
  return ( numerator == op2.getNumerator() &&
           denominator == op2.getDenominator() );
}

//-----------------------------------------------------------------
//  Returns this rational number as a string.
//-----------------------------------------------------------------
public String toString()
{
  String result;

  if (numerator == 0)
     result = "0";
  else
     if (denominator == 1)
        result = numerator + "";
     else
        result = numerator + "/" + denominator;

  return result;
}

//-----------------------------------------------------------------
//  Compares this RationalNumber2 object to the parameter.
//-----------------------------------------------------------------
public int compareTo(RationalNumber2 obj)
{
 float num = numerator / (float)denominator;
 float num2 = obj.numerator / (float)obj.denominator;
 
 if(num >= num2 - TOLERANCE && num <= num2 + TOLERANCE)
     return 0;
 else if(num < num2 - TOLERANCE)
     return -1;
 else
     return 1;
}

//-----------------------------------------------------------------
//  Reduces this rational number by dividing both the numerator
//  and the denominator by their greatest common divisor.
//-----------------------------------------------------------------
private void reduce()
{
  if (numerator != 0)
  {
     int common = gcd(Math.abs(numerator), denominator);

     numerator = numerator / common;
     denominator = denominator / common;
  }
}

//-----------------------------------------------------------------
//  Computes and returns the greatest common divisor of the two
//  positive parameters. Uses Euclid's algorithm.
//-----------------------------------------------------------------
private int gcd(int num1, int num2)
{
  while (num1 != num2)
     if (num1 > num2)
        num1 = num1 - num2;
     else
        num2 = num2 - num1;

  return num1;
}

@Override
public int compareTo(Object arg0) {
	// TODO Auto-generated method stub
	return 0;
}
}
