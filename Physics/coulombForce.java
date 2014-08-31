import java.util.Scanner;
import java.lang.Math;


public class coulombForce {
	
	public static double coulombF(double q1, double q2, double r) {
		final double e = 8.854E-12;
		return (q1*q2)/(4*Math.PI*e*Math.sqrt(r));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Q1 : ");
		double q1 = in.nextDouble();
		System.out.print("Q2 : ");
		double q2 = in.nextDouble();
		System.out.print("r : ");
		double r = in.nextDouble();
		System.out.printf("F_e = %.2f", coulombF(q1, q2, r)); 
		//something is not right, result does not agree with the example 23.2 in physics books
		in.close();
	}

}
