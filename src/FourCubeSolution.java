import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

// SumOfCubes
// A program that takes input from the integers 1 to 1000 and
// returns four or fewer integers whose cubes sum to the input
//
// Created by Earnest Wheeler on 4/26/15.
// Copyright (c) 2015 Earnest Wheeler. All rights reserved.
//
// Thanks to Dario Alejandro Alpern (Buenos Aires - Argentina)
// For his java applet at http://www.alpertron.com.ar/FCUBES.HTM
// And the equations and source code that he kindly provided
// The code for the Pell solution to Demjanenko's equation is 
//   directly taken from his source code.

public class FourCubeSolution {
    BigInteger first;
    BigInteger second;
    BigInteger third;
    BigInteger fourth;
    boolean isNegated = false;

    public FourCubeSolution(BigInteger _first, BigInteger _second, BigInteger _third, BigInteger _fourth) {
	this.first = _first;
	this.second = _second;
	this.third = _third;
	this.fourth = _fourth;
    }



    public void solveFor(BigInteger n) {

	int mod18 = n.mod(BigInteger.valueOf(18)).intValue();
	if (mod18 == 4 || mod18 == 5 || mod18 == 13 || mod18 == 14) {
	      throw new IllegalArgumentException("This applet does not work if the number is congruent to 4 or 5 (mod 9).");
	}
	
	BigInteger remainderSix = n.mod(BigInteger.valueOf(6)); // the remainder of n/6
	BigInteger x = n.divide(BigInteger.valueOf(6));
	if (isNegated) { x = x.subtract(BigInteger.ONE); }
	if (remainderSix.equals(BigInteger.ZERO)) {
	    this.first = x.add(BigInteger.valueOf(-1));
	    this.second = x.multiply(BigInteger.valueOf(-1));
	    this.third = x.multiply(BigInteger.valueOf(-1));
	    this.fourth = x.add(BigInteger.ONE);
	    return;
	}
	else if (remainderSix.equals(BigInteger.valueOf(3))) {
	    this.first = x;
	    this.second = x.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(4));
	    this.third = x.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(-5));
	    this.fourth = x.multiply(BigInteger.valueOf(-2)).add(BigInteger.valueOf(4));
	    return;
	}


	BigInteger remainderET = n.mod(BigInteger.valueOf(18)); // the remainder of n/18
	x = n.divide(BigInteger.valueOf(18));
	if (isNegated) { x = x.subtract(BigInteger.ONE); }
	if (remainderET.equals(BigInteger.ONE)) {
	    this.first = x.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(14));
	    this.second = x.multiply(BigInteger.valueOf(-2)).add(BigInteger.valueOf(-23));
	    this.third = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(-26));
	    this.fourth = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(30));
	    return;
	}
	else if (remainderET.equals(BigInteger.valueOf(7))) {
	    this.first = x.add(BigInteger.valueOf(2));
	    this.second = x.multiply(BigInteger.valueOf(6)).add(BigInteger.valueOf(-1));
	    this.third = x.multiply(BigInteger.valueOf(8)).add(BigInteger.valueOf(-2));
	    this.fourth = x.multiply(BigInteger.valueOf(-9)).add(BigInteger.valueOf(2));
	    return;
	}
	else if (remainderET.equals(BigInteger.valueOf(8))) {
	    this.first = x.add(BigInteger.valueOf(-5));
	    this.second = x.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(14));
	    this.third = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(29));
	    this.fourth = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(-30));
	    return;
	}


	BigInteger remainderTS = n.mod(BigInteger.valueOf(270)); // the remainder of n/270
	x = n.divide(BigInteger.valueOf(270));
	if (isNegated) { x = x.subtract(BigInteger.ONE); }
	if (remainderTS.equals(BigInteger.valueOf(146))) {
	    this.first = x.multiply(BigInteger.valueOf(-60)).add(BigInteger.valueOf(91));
	    this.second = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(13));
	    this.third = x.multiply(BigInteger.valueOf(22)).add(BigInteger.valueOf(-37));
	    this.fourth = x.multiply(BigInteger.valueOf(59)).add(BigInteger.valueOf(-89));
	    return;
	} else if (remainderTS.equals(BigInteger.valueOf(200))) {
	    this.first = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(259));
	    this.second = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(-254));
	    this.third = x.add(BigInteger.valueOf(62));
	    this.fourth = x.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(-107));
	    return;
	} else if (remainderTS.equals(BigInteger.valueOf(218))) {
	    this.first = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(-56));
	    this.second = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(31));
	    this.third = x.multiply(BigInteger.valueOf(-5)).add(BigInteger.valueOf(-69));
	    this.fourth = x.multiply(BigInteger.valueOf(5)).add(BigInteger.valueOf(78));
	    return;
	}


	if (n.mod(BigInteger.valueOf(54)).equals(BigInteger.valueOf(20))) {
	    x = n.divide(BigInteger.valueOf(54));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(-11));
	    this.second = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(10));
	    this.third = x.add(BigInteger.valueOf(2));
	    this.fourth = x.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(7));
	    return;
	}

	if (n.mod(BigInteger.valueOf(72)).equals(BigInteger.valueOf(56))) {
	    x = n.divide(BigInteger.valueOf(72));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-9)).add(BigInteger.valueOf(4));
	    this.second = x.add(BigInteger.valueOf(4));
	    this.third = x.multiply(BigInteger.valueOf(6)).add(BigInteger.valueOf(-2));
	    this.fourth = x.multiply(BigInteger.valueOf(8)).add(BigInteger.valueOf(-4));
	    return;
	}

	if (n.mod(BigInteger.valueOf(108)).equals(BigInteger.valueOf(2))) {
	    x = n.divide(BigInteger.valueOf(108));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(-22));
	    this.second = x.add(BigInteger.valueOf(4));
	    this.third = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(-41));
	    this.fourth = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(43));
	    return;
	}

	if (n.mod(BigInteger.valueOf(216)).equals(BigInteger.valueOf(92))) {
	    x = n.divide(BigInteger.valueOf(216));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(-164));
	    this.second = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(160));
	    this.third = x.add(BigInteger.valueOf(-35));
	    this.fourth = x.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(71));
	    return;
	}

	if (n.mod(BigInteger.valueOf(540)).equals(BigInteger.valueOf(38)) ) {
	    x = n.divide(BigInteger.valueOf(540));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(5)).add(BigInteger.valueOf(-285));
	    this.second = x.multiply(BigInteger.valueOf(-5)).add(BigInteger.valueOf(267));
	    this.third = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(-140));
	    this.fourth = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(190));
	    return;
	}

	if ( n.mod(BigInteger.valueOf(432)).equals(BigInteger.valueOf(380)) ) {
	    x = n.divide(BigInteger.valueOf(432));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(64));
	    this.second = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(-80));
	    this.third = x.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(-29));
	    this.fourth = x.multiply(BigInteger.valueOf(-2)).add(BigInteger.valueOf(65));
	    return;
	}

	if ( n.mod(BigInteger.valueOf(810)).equals(BigInteger.valueOf(56)) ) {
	    x = n.divide(BigInteger.valueOf(810));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(5)).add(BigInteger.valueOf(-755));
	    this.second = x.multiply(BigInteger.valueOf(-5)).add(BigInteger.valueOf(836));
	    this.third = x.multiply(BigInteger.valueOf(9)).add(BigInteger.valueOf(-1445));
	    this.fourth = x.multiply(BigInteger.valueOf(-9)).add(BigInteger.valueOf(1420));
	    return;
	}
	
	if ( n.mod(BigInteger.valueOf(1080)).equals(BigInteger.valueOf(380)) ) {
	    x = n.divide(BigInteger.valueOf(1080));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-1)).add(BigInteger.valueOf(-1438));
	    this.second = x.multiply(BigInteger.valueOf(1)).add(BigInteger.valueOf(1258));
	    this.third = x.multiply(BigInteger.valueOf(-3)).add(BigInteger.valueOf(-4037));
	    this.fourth = x.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(4057));
	    return;
	}
	
	if ( n.mod(BigInteger.valueOf(1620)).equals(BigInteger.valueOf(1334)) ) {
	    x = n.divide(BigInteger.valueOf(1620));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-5)).add(BigInteger.valueOf(-3269));
	    this.second = x.multiply(BigInteger.valueOf(5)).add(BigInteger.valueOf(3107));
	    this.third = x.multiply(BigInteger.valueOf(-9)).add(BigInteger.valueOf(-5714));
	    this.fourth = x.multiply(BigInteger.valueOf(9)).add(BigInteger.valueOf(5764));
	    return;
	}

	if ( n.mod(BigInteger.valueOf(1620)).equals(BigInteger.valueOf(1352)) ) {
	    x = n.divide(BigInteger.valueOf(1620));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-5)).add(BigInteger.valueOf(434));
	    this.second = x.multiply(BigInteger.valueOf(5)).add(BigInteger.valueOf(-353));
	    this.third = x.multiply(BigInteger.valueOf(9)).add(BigInteger.valueOf(-722));
	    this.fourth = x.multiply(BigInteger.valueOf(-9)).add(BigInteger.valueOf(697));
	    return;
	}
	
	if ( n.mod(BigInteger.valueOf(2160)).equals(BigInteger.valueOf(362)) ) {
	    x = n.divide(BigInteger.valueOf(2160));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-5)).add(BigInteger.valueOf(-180));
	    this.second = x.multiply(BigInteger.valueOf(5)).add(BigInteger.valueOf(108));
	    this.third = x.multiply(BigInteger.valueOf(-6)).add(BigInteger.valueOf(-149));
	    this.fourth = x.multiply(BigInteger.valueOf(6)).add(BigInteger.valueOf(199));
	    return;
	}
	
	if ( n.mod(BigInteger.valueOf(6480)).equals(BigInteger.valueOf(794)) ) {
	    x = n.divide(BigInteger.valueOf(6480));
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = x.multiply(BigInteger.valueOf(-5)).add(BigInteger.valueOf(-83));
	    this.second = x.multiply(BigInteger.valueOf(5)).add(BigInteger.valueOf(11));
	    this.third = x.multiply(BigInteger.valueOf(-6)).add(BigInteger.valueOf(-35));
	    this.fourth = x.multiply(BigInteger.valueOf(6)).add(BigInteger.valueOf(85));
	    return;
	}
	

	if ( n.equals(BigInteger.valueOf(164)) ) {
	    if (isNegated) { x = x.subtract(BigInteger.ONE); }
	    this.first = BigInteger.valueOf(272032);
	    this.second = BigInteger.valueOf(-271868);
	    this.third = BigInteger.valueOf(89911);
	    this.fourth = BigInteger.valueOf(-91387);
	    return;
	}

	if ( n.equals(BigInteger.valueOf(596)) ) {
	    this.first = BigInteger.valueOf(3591928);
	    this.second = BigInteger.valueOf(-3591332);
	    this.third = BigInteger.valueOf(1194527);
	    this.fourth = BigInteger.valueOf(-1199891);
	    return;
	}

	if (n.equals(BigInteger.valueOf(254)) || n.equals(BigInteger.valueOf(902)) ||
		n.equals(BigInteger.valueOf(-178)) ||  n.equals(BigInteger.valueOf(-718)) ||
		n.equals(BigInteger.valueOf(-826))) {
	    // Perform Pell solution of Demjanenko's theorem
	    // Using these values of P, Q, R and S, a and b will be
	    // always one and zero (mod 6) respectively.
	    BigInteger P = new BigInteger("-112488782561");
	    BigInteger Q = new BigInteger("-6578430178320");
	    BigInteger R = new BigInteger("-1923517596");
	    BigInteger S = P;
	    BigInteger tmpA;
	    int mod83 = n.mod(BigInteger.valueOf(83)).intValue();
	    int pow = 71;
	    int exp = 0;
	    while (pow != mod83) {
		exp++;
		pow = (pow*50)%83;
	    }
	    if (exp > 82/2) {
		exp = 82 - exp;
		Q = Q.negate();
		R = R.negate();
	    }
	    BigInteger P1 = BigInteger.valueOf(1);
	    BigInteger Q1 = BigInteger.valueOf(0);
	    BigInteger R1 = Q1;
	    BigInteger S1 = P1;
	    int mask = 32;
	    while (mask > 0) {
		BigInteger tmpP1 = P1.pow(2).add(Q1.multiply(R1));
		BigInteger tmpQ1 = P1.add(S1).multiply(Q1);
		BigInteger tmpR1 = P1.add(S1).multiply(R1);
		BigInteger tmpS1 = S1.pow(2).add(Q1.multiply(R1));
		P1 = tmpP1;
		Q1 = tmpQ1;
		R1 = tmpR1;
		S1 = tmpS1;
		if ((exp & mask) != 0) {
		    tmpP1 = P.multiply(P1).add(Q.multiply(R1));
		    tmpQ1 = P.multiply(Q1).add(Q.multiply(S1));
		    tmpR1 = R.multiply(P1).add(S.multiply(R1));
		    tmpS1 = R.multiply(Q1).add(S.multiply(S1));
		    P1 = tmpP1;
		    Q1 = tmpQ1;
		    R1 = tmpR1;
		    S1 = tmpS1;
		}
		mask /= 2;
	    }
	    BigInteger a = P1.multiply(BigInteger.valueOf(-3041)).
		    add(Q1.multiply(BigInteger.valueOf(-52)));
	    BigInteger b = R1.multiply(BigInteger.valueOf(-3041)).
		    add(S1.multiply(BigInteger.valueOf(-52)));

	    BigInteger Mult1 = a.multiply(BigInteger.valueOf(27)).
		    add(b.multiply(BigInteger.valueOf(-928)));
	    BigInteger Mult2 = a.multiply(BigInteger.valueOf(-9)).
		    add(b.multiply(BigInteger.valueOf(-602)));
	    BigInteger Mult3 = a.multiply(BigInteger.valueOf(25)).
		    add(b.multiply(BigInteger.valueOf(-2937)));
	    BigInteger Mult4 = a.multiply(BigInteger.valueOf(-19)).
		    add(b.multiply(BigInteger.valueOf(2746)));
	    BigInteger k = n.subtract(Mult1.pow(3)).subtract(Mult2.pow(3)).
		    subtract(Mult3.pow(3)).subtract(Mult4.pow(3)).
		    divide(BigInteger.valueOf(18*83));
	    this.first = Mult1.add(k.multiply(BigInteger.valueOf(10)));
	    this.second = Mult2.add(k.multiply(BigInteger.valueOf(-19)));
	    this.third = Mult3.add(k.multiply(BigInteger.valueOf(-24)));
	    this.fourth = Mult4.add(k.multiply(BigInteger.valueOf(27)));
	    return;
	}



	if (n.compareTo(BigInteger.ZERO) > 0) {
	    this.isNegated = true;
	    solveFor(n.negate());
	} else {
	    n.multiply(BigInteger.valueOf(-1));
	    throw new IllegalArgumentException(n.toString() + " does not have a known solution in 4 cubes");
	}
    }

    public FourCubeSolution(long n) {
	this.solveFor(BigInteger.valueOf(n));
	if (isNegated) {
	    this.first = this.first.negate();
	    this.second = this.second.negate();
	    this.third = this.third.negate();
	    this.fourth = this.fourth.negate();
	}
    }

    public BigInteger sum() {
	return this.first.pow(3).add(this.second.pow(3)).add(this.third.pow(3)).add(this.fourth.pow(3));
    }

    public String list() {
	return this.first.toString() + ", \n" + 
		this.second.toString() + ", \n" +
		this.third.toString() + ", \n" +
		this.fourth.toString();
    }

    public String print() {
	return this.first.toString() + "^3 + " + 
		this.second.toString() + "^3 + " +
		this.third.toString() + "^3 + " +
		this.fourth.toString() + "^3";
    }

    public static void main(String [] args) throws Exception {
	PrintWriter pen = new PrintWriter(System.out, true);
	InputStreamReader istream = new InputStreamReader(System.in);
	BufferedReader eyes = new BufferedReader(istream);
	String expression = "";
	FourCubeSolution output;
	boolean loopchecker = true;
	pen.println("Welcome to the Four Cubes Calculator!");
	pen.println("Enter an integer in the range 0-1000 to see it expressed as a sum of four cubes.");
	pen.println("Only integers not congruent to 4 or 5 mod 9 are supported.");
	while (loopchecker) {
	    pen.println("Input a value or \"Quit\" to exit the calculator: ");
	    expression = eyes.readLine();
	    if (expression.compareTo("quit") == 0
		    || expression.compareTo("Quit") == 0) {
		pen.println("Program terminated");
		loopchecker = false; // check this
	    } else {
		try {
		    long target = Integer.parseInt(expression);
		    if (target >= 0 || target <= 1000) {
			output = new FourCubeSolution(target);
			pen.println(output.print());
		    } else {
			throw new Exception("ERROR: Invalid Input");
		    }

		} catch (Exception e) {
		    pen.println("ERROR: " + e.getMessage());
		}
	    }
	}
    }
}
