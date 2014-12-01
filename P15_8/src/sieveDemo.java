import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class sieveDemo {

	public static void fillSet(Set<Integer> thePrimes, int n) {
		int counter = 2;
		while(counter <= n)
			thePrimes.add(counter++);
	}
	
	public static void removeEven(Set<Integer> mySet, int n) {
		int sqrt_n = (int) Math.sqrt(n);
		for (int i = 2; i < sqrt_n + 3; i+=2) {
			mySet.remove(new Integer(i));
		}
	}

	public static void removeOdd(Set<Integer> mySet, int n) {
		int sqrt_n = (int) Math.sqrt(n);
		for (int i = 3; i < sqrt_n + 3; i+=3) {
			mySet.remove(new Integer(i));
		}
	}

	public static void main(String[] args) {
		
		
		// choose n
		// inert all numbers from 2 to n into a set
		// erase all multiples of 2(except 2)
		// erase all multiples of 3
		// all the way up to \sqrt(n)
		// print the set
		
		Set<Integer> myPrimes = new TreeSet<>();
		int n;

		System.out.print("Choose the n : ");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		fillSet(myPrimes, n);
		System.out.println("square root of n is " + (int) Math.sqrt(n));
		removeEven(myPrimes, n);
		removeOdd(myPrimes, n);
		
		System.out.println(myPrimes.toString());
		
	}

}
