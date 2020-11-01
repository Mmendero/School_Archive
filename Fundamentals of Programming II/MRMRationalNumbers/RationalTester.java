package MRMRationalNumbers;

//********************************************************************
//RationalTester2.java       Author: Lewis/Loftus
//
//Solution to Programming Project 7.4
//********************************************************************
public class RationalTester
{
//-----------------------------------------------------------------
//  Tests the Comparable nature of RationalNumber2 objects.
//-----------------------------------------------------------------
public static void main(String[] args)
{
  RationalNumber2 r1 = new RationalNumber2(2, 3);
  RationalNumber2 r2 = new RationalNumber2(2, 3);

  System.out.println("First rational number: " + r1);
  System.out.println("Second rational number: " + r2);
  int compareValue = r1.compareTo(r2);

  if (compareValue == 0)
     System.out.println("r1 and r2 are equal.");
  else
     if (compareValue < 0)
        System.out.println("r1 is less than r2");
     else
        System.out.println("r1 is greater than r2");

  RationalNumber2 r3 = new RationalNumber2(6, 7);
  RationalNumber2 r4 = new RationalNumber2(6, 7);

  System.out.println("Third rational number: " + r3);
  System.out.println("Fourth rational number: " + r4);
  compareValue = r3.compareTo(r4);

  if (compareValue == 0)
     System.out.println("r3 and r4 are equal.");
  else
     if (compareValue < 0)
        System.out.println("r3 is less than r4");
     else
        System.out.println("r3 is greater than r4");

  RationalNumber2 r5 = new RationalNumber2(4, 7);
  RationalNumber2 r6 = new RationalNumber2(5, 6);

  System.out.println("Fifth rational number: " + r5);
  System.out.println("Sixth rational number: " + r6);
  compareValue = r5.compareTo(r6);

  if (compareValue == 0)
     System.out.println("r5 and r6 are equal.");
  else
     if (compareValue < 0)
        System.out.println("r5 is less than r6");
     else
        System.out.println("r5 is greater than r6");
}
}

