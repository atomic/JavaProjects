import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class studentTester {

	public static void main(String[] args) {
		
		Map<Student, String> myStudents = new TreeMap<>();
		
		String option;
		String tempFirstName;
		String tempLastName;
		String grade;
		
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("Add more student and its grade ? (y/n) : ");
			option = in.next();
			if(option.equals("n"))
				break;
			System.out.print("Enter first name of student : ");
			tempFirstName = in.next();
			System.out.print("Enter last name of student : ");
			tempLastName = in.next();
			System.out.print("Enter his/her grade : ");
			grade = in.next();

			System.out.println();
			myStudents.put(new Student(tempFirstName, tempLastName), grade);
			
			System.out.println("Here are the list of your students : ");
			for (Student theStudent : myStudents.keySet()) {
				System.out.println(theStudent + ": " + myStudents.get(theStudent));
			}
		}


	}

}

/**
 * Test Case
 * Add more student and its grade ? (y/n) : y
 * Enter first name of student : Tony Salim
 * Enter last name of student : Enter his/her grade : A

 * Here are the list of your students : 
 * Salim, Tony: A
 * Add more student and its grade ? (y/n) : y
 * Enter first name of student : Willy
 * Enter last name of student : Salim
 * Enter his/her grade : C
 * 
 * Here are the list of your students : 
 * Salim, Tony: A
 * Salim, Willy: C
 * Add more student and its grade ? (y/n) : y
 * Enter first name of student : Gondor
 * Enter last name of student : Stark
 * Enter his/her grade : D
 * 
 * Here are the list of your students : 
 * Salim, Tony: A
 * Salim, Willy: C
 * Stark, Gondor: D
 * Add more student and its grade ? (y/n) : y
 * Enter first name of student : Bruce
 * Enter last name of student : Wayne
 * Enter his/her grade : A+
 * 
 * Here are the list of your students : 
 * Salim, Tony: A
 * Salim, Willy: C
 * Stark, Gondor: D
 * Wayne, Bruce: A+
 * Add more student and its grade ? (y/n) : y
 * Enter first name of student : James
 * Enter last name of student : Maxwell
 * Enter his/her grade : A+
 * 
 * Here are the list of your students : 
 * Maxwell, James: A+
 * Salim, Tony: A
 * Salim, Willy: C
 * Stark, Gondor: D
 * Wayne, Bruce: A+
 * Add more student and its grade ? (y/n) : y
 * Enter first name of student : Tony
 * Enter last name of student : Stark
 * Enter his/her grade : A
 * 
 * Here are the list of your students : 
 * Maxwell, James: A+
 * Salim, Tony: A
 * Salim, Willy: C
 * Stark, Gondor: D
 * Stark, Tony: A
 * Wayne, Bruce: A+
 * Add more student and its grade ? (y/n) : y
 * Enter first name of student : Tony
 * Enter last name of student : Salim
 * Enter his/her grade : B
 * 
 * Here are the list of your students : 
 * Maxwell, James: A+
 * Salim, Tony: B
 * Salim, Tony: A
 * Salim, Willy: C
 * Stark, Gondor: D
 * Stark, Tony: A
 * Wayne, Bruce: A+
 * Add more student and its grade ? (y/n) : n
 * 
 *  */