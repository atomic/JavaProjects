package cs3b.p8;

import java.util.Arrays;
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
	private String[] colorbands;
	
	public Resistor(double nom, double tolerance) {
		nominalValue = nom;
		tolerancePerc = tolerance;
		toleranceBound[0] = nom - nom*tolerance;
		toleranceBound[1] = nom + nom*tolerance;
		actualValue = toleranceBound[0] + (new Random().nextDouble())*( toleranceBound[1] - toleranceBound[0]);
		colorbands = processColor();
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
	
	/**
	 * The function will process nominalvalue and tolerance percentage,
	 * then produce 4 colors that describe a resistor
	 * @return string array that stores 4 color
	 */
	private String[] processColor() {
	    String[] colorbands = new String[4];
	    // first, get the first digit
	    String nominalString = Integer.toString((int)nominalValue); // note : nominalValue can be double
	    int string_length = nominalString.length();
	    char firstDigit = nominalString.charAt(0);
	    char secondDigit;
	    
	    int multiplier = 0;
	    if(string_length == 1)
		secondDigit = '-'; //means no 2nd digit
	    else {
		if(nominalString.charAt(1) != '0') {
		    secondDigit = nominalString.charAt(1);
		    multiplier = string_length - 2; //if second digit is not zero
		}
		else {
		    secondDigit = '-';
		    multiplier = string_length - 1; // if second digit is zero, make it part of multiplier
		}
	    }
		
	    //now, categorize the color
	    colorbands[0] = firstDigit != '-' ? getColor(Character.getNumericValue(firstDigit)) : "None";
	    colorbands[1] = secondDigit!= '-' ? getColor(Character.getNumericValue(secondDigit)) : "None";
	    colorbands[2] = getColor(multiplier);
	    
	    //now, get the color for tolerance
	    double toleranceTemp = tolerancePerc*100; //format .02 to 2 (%),etc
	    if(almostEqual(toleranceTemp, 1.0, 0.01)) { colorbands[3] = "Brown"; }
	    else if(almostEqual(toleranceTemp, 2.0, 0.01)) { colorbands[3] = "Red"; }
	    else if(almostEqual(toleranceTemp, 0.5, 0.01)) { colorbands[3] = "Green"; }
	    else if(almostEqual(toleranceTemp, 0.25, 0.01)) { colorbands[3] = "Blue"; }
	    else if(almostEqual(toleranceTemp, 0.1, 0.01)) { colorbands[3] = "Violet"; }
	    else if(almostEqual(toleranceTemp, 0.05, 0.01)) { colorbands[3] = "Gray"; }
	    else if(almostEqual(toleranceTemp, 5.0, 0.01)) { colorbands[3] = "Gold"; }
	    else if(almostEqual(toleranceTemp, 10, 0.01)) { colorbands[3] = "Silver"; }
	    else if(almostEqual(toleranceTemp, 20, 0.01)) { colorbands[3] = "None"; }
	    
	    return colorbands;
	}
	
	/**
	 * The function takes integer value that will work for digit and power of multiplier
	 * @param value
	 * @return color
	 */
	private String getColor(int value) {
	    switch (value) {
		case 0: return "Black";
		case 1: return "Brown";
		case 2: return "Red";
		case 3: return "Orange";
		case 4: return "Yellow";
		case 5: return "Green";
		case 6: return "Blue";
		case 7: return "Violet";
		case 8: return "Gray";
		case 9: return "White";
		//special case for multiplier (not implemented yet)
		case -1 : return "Gold";
		case -2 : return "Silver";
		default: return "None";
	    }
	    
	}

	public static boolean almostEqual(double a, double b, double eps){
	    return Math.abs(a-b)<eps;
	}

	public void display() {
	    System.out.printf("\n%.2f +- %d %% resitance.\n", nominalValue, (int)(tolerancePerc*100) );
	    System.out.printf("from %.2f to %.2f.\n", toleranceBound[0], toleranceBound[1]);
	    System.out.printf("Actual : %.2f.\n", actualValue);
	    System.out.println("Color bands " + Arrays.deepToString(colorbands));
	}
}
