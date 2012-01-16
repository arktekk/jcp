package demo.newlanguagefeatures;

import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.tan;

import static java.awt.Color.*;

public class StaticImports {

	public static void main(String[] args) {
		testMathStatics();
		testColorStatics();
	}

	private static void testMathStatics() {
		double angle = 2 * PI;
		System.out.println("Sin of angle: " + sin(angle));
		System.out.println("Cos of angle: " + cos(angle));
		System.out.println("Tan of angle: " + tan(angle));
	}

	private static void testColorStatics() {
		System.out.println("My favourite colour is " + RED);
		System.out.println("I also quite like " + GREEN);
	}
}