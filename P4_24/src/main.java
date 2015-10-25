
/*
Author:Benjamin Loh & Tony Lim
Date: September 2, 2014
 
 P4-24
Description: Monty Hall Paradox

 
 */
//import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		int car = 0, player = 0, counter = 0, counter2 = 0, host = 0;
		
		for(int i =0; i <1000; i++){
			car = (int) (Math.random() * 3)+1; //generates random number between 1 & 3
			
			player = (int)(Math.random() * 3)+1; //generates random number between 1 & 3
			
			if(car == player)
				counter = counter +1; // sets counter when player and car are equal
					
		}
		System.out.print("Win counter when player sticks with original choice:");
		System.out.println(counter); // prints out how many times player wins
		for(int i = 0; i <1000; i++){
				
			car = (int) (Math.random() * 3)+1; //generates random number between 1 & 3
			player = (int)(Math.random() * 3)+1; //generates random number between 1 & 3
			if(car == 1 && player == 1)
				host = 2;					
			if(car == 1 && player == 2)		
				host = 1;
			if(car == 1 && player == 3) // these if statements find out where the goat is
				host = 1;				// and it makes the user switch their previous answer
			if(car == 2 && player == 1) // to the door that host suggests
				host = 2;
			if(car == 2 && player == 2)
				host = 1;
			if(car == 2 && player == 3)
				host = 2;
			if(car == 3 && player == 1)
				host = 3;
			if(car == 3 && player == 2)
				host = 3;
			if(car == 3 && player == 3)
				host = 2;
			
					
			if(car == host)
				counter2 = counter2 +1; //counter for when player switches choice
		}
		System.out.print("Win Counter when Player switches choice:");
		System.out.println(counter2);
		
		
		

	}

}
/*
Sample 1:
Win counter when player sticks with original choice:339
Win Counter when Player switches choice:683

Sample 2:
Win counter when player sticks with original choice:331
Win Counter when Player switches choice:692

Sample 3:
Win counter when player sticks with original choice:341
Win Counter when Player switches choice:674








*/
