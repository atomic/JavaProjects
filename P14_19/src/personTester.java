import java.util.Scanner;

import com.sun.prism.sw.SWPipeline;

/* Name : Tony Lim
 * Date : 2014/11/06
 */

public class personTester {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String tempName = new String();;
        Person[] personList = new Person[10];
        
        for (int i = 0; i < personList.length; i++) {
            personList[i] = new Person();
        }
        
        System.out.println("Please enter 10 names : ");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.print(">> ");
                tempName = in.next();
//                System.out.println(tempName);
                personList[i].setName(tempName);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        in.close();

        System.out.println("Here are the list of names:");
        for (int i = 0; i < 10; i++)
            System.out.println(" - " + personList[i].getName());

        Sort(personList, 0, 9);
        System.out.println("Here are the sorted names(lexical):");
        for (int i = 0; i < 10; i++)
            System.out.println(" - " + personList[i].getName());
        
        System.out.println("First person : " + personList[0].getName());
        System.out.println("Last  person : " + personList[9].getName());

    }

    /**
     *
     * Sorting array using bubble sort
     * @param a
     * @return
     */
    public static void  Sort(Person[] a, int from, int to)
    {
        int pivot = 0;
        int i = 1;
        while(pivot < to + 1)
        {
            while(i < to + 1) 
            {
                if(a[pivot].compareTo(a[i]) < 0) {
                	Swap(a, pivot, i);
                }
                i++;
            }
            pivot++; i = (pivot+1);
        }
    }

    public static void Swap(Person[] array, int a, int b)
    {
        Person temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

/**
 * Test case
 * 
Please enter 10 names : 
>> Tony
>> Kirchoff
>> Newton
>> Lagrange
>> Hilbert
>> Bernoulli
>> Tesla
>> Galilei
>> Feynman
>> Einstein

Here are the list of names:
 - Tony
 - Kirchoff
 - Newton
 - Lagrange
 - Hilbert
 - Bernoulli
 - Tesla
 - Galilei
 - Feynman
 - Einstein
Here are the sorted names(lexical):
 - Tony
 - Tesla
 - Newton
 - Lagrange
 - Kirchoff
 - Hilbert
 - Galilei
 - Feynman
 - Einstein
 - Bernoulli
First person : Tony
Last  person : Bernoulli

*/
