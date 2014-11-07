import java.util.Arrays;
import java.util.Random;

/* Name : Tony Lim
 * Date : Nov 7, 2014
 * Assignment : P14.21
 * Description : Sorting string according to length and lexical order
 */


public class StringSorterDemo {
	
	
	public static void main(String[] args) {
		
		Random r = new Random();
		String[] stringList = new String[20];
		for (int i = 0; i < stringList.length; i++) {
			stringList[i] = getRandomString(5) + getRandomString(r.nextInt(8)); //from 5 - 13
		}
		
		System.out.println("Here are the unsorted random strings : ");

		for (String string : stringList)
			System.out.println(string);
		
		System.out.println();
		Arrays.sort(stringList, new LexicalStringComparator());
		
		System.out.println("Here are sorted version : ");
		for (String string : stringList)
			System.out.println(string);

	}

	public static String getRandomString(int length) {
		
		Random r = new Random();
		
		String a = new String();
		for (int i = 0; i < length; i++)
			a += (char)(r.nextInt(26) + 'a');
		
		return a;
	}
	
}
