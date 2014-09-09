import java.util.ArrayList;

/* Name : Tony Lim
 * Date : Sep 9, 2014
 * Assignment : P6.28
 * Description : The program is used to sort to arraylist where the elements are sorted
 */


public class mergeSorted {

	public static void main(String[] args) {
		
		//declare and fill the elements similar to the questions in the book
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		a.add(1);
		a.add(4);
		a.add(9);
		a.add(16);
		b.add(4);
		b.add(7);
		b.add(9);
		b.add(9);
		b.add(11);
		System.out.print("a : ");
		for (Integer integer : a)
			System.out.print(integer + ", ");
		System.out.println();
		System.out.print("b : ");
		for (Integer integer : b)
			System.out.print(integer + ", ");
		System.out.println();

		//result of mergeSorted
		System.out.print("mergeSorted : ");
		for (Integer integer : mergeSorted(a, b)) //here i just pass in the result of the function, which is ArraList
			System.out.print(integer + ", ");
	
	}

	/**
	 * The function will move elements from both a and b to new elements in a new ArraList
	 * 
	 * @param a the first sets of integer
	 * @param b the second sets of integer
	 * @return the sorted new arraylist that have elements from a and b
	 */
	public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b) {
		
		//these are the index that keep track of where the last location of inserted value from a or b
		int index_a = 0;
		int index_b = 0;
		ArrayList<Integer> sortedList = new ArrayList<>(); // the empty ArrayList to be filled 

		//this is the main technique to move a and b to new arratlist
		while(index_a < a.size() && index_b < b.size()) {
			if(a.get(index_a) < b.get(index_b))
				sortedList.add(a.get(index_a++)); //after moved elements in a, increment the tracker
			else
				sortedList.add(b.get(index_b++)); //after moved elements in b, increment the tracker
		}

		//after the loop above, a or b has some elements left
		if(a.size() == index_a)
			for(int i = index_b; i < b.size(); i++)
				sortedList.add(b.get(i));
		else
			for(int i = index_a; i < a.size(); i++)
				sortedList.add(a.get(i));
		return sortedList;
	}
}

/**  	------------- TEST CASES ----------
 * @assumptions : none
 * @preconditions : none

Test Cases:

a : 1, 4, 9, 16, 
b : 4, 7, 9, 9, 11, 
mergeSorted : 1, 4, 4, 7, 9, 9, 9, 11, 16, 


*/