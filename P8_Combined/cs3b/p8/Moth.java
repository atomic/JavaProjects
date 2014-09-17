package cs3b.p8;

/**
 * Implemenet a models of moth flying in a straight line.
 *
 */
public class Moth {

	private double x;
	public Moth(double initialPosition) {
		x = initialPosition;
	}
	
	public void getPosition() {
		System.out.println("Position is  : " + x);
	}
	
	public void moveToLight(double lightPosition) {
		System.out.println("Debug, x = " + x);
		x += (lightPosition - x)/2.0;
	}
	
}
