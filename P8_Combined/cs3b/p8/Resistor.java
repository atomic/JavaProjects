package cs3b.p8;

import java.util.Random;

/**
 * The class represent a Resistor that will calculate and stores the tolerance,
 * and determines the actual value randomly
 * @author Tony LIm
 *
 */
public class Resistor {
	private double nominalValue;
	private double actualValue;
	private final double tolerancePerc; // 5% as default
	private double[] toleranceBound = new double[2]; //store upper and lower bound
	private final String unit;
	
	public Resistor(double nom, double tolerance) {
		nominalValue = nom;
		tolerancePerc = tolerance;
		toleranceBound[0] = nom - nom*tolerance;
		toleranceBound[1] = nom + nom*tolerance;
		actualValue = toleranceBound[0] + (new Random().nextDouble())*( toleranceBound[1] - toleranceBound[0]);
		unit = "Ohm"; //what is ascii for ohm symbol?
	}
	
	public Resistor(double nom) {
		this(nom, 5.0/100);
	}
	
	public double getNominal() {
		return nominalValue;
	}
	
	public double[] getTolerance() {
		return toleranceBound;
	}

	public double getActual() {
		return actualValue;
	}
	
	public void display() {
		System.out.printf("%0.2f +- %d \\% resitance.\n", nominalValue, tolerancePerc*100);
		System.out.printf("Actual : %.2f.\n", actualValue);
	}
}
