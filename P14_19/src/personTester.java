import java.util.Scanner;

/* Name : Name
 * Date : 2014/11/06
 * Assignment : Px.y
 * Description : Descriptions
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
        for (int i = 0; i < 10; i++) {
            System.out.println(personList[i].getName());
        }
        
        System.out.printf("Comparing first person(%s) and last person(%s) name in lexical order\n",
        		personList[0].getName(), personList[9].getName());
        
        System.out.println( "result : " + personList[0].compareTo(personList[9]));

    }
}

/**
 * Test case
 * 
Please enter 10 names : 
>> tony
>> djain
>> jim
>> marley
>> gobarchev
>> sandi
>> trianna
>> kim
>> surluk
>> valxion
Here are the list of names:
tony
djain
jim
marley
gobarchev
sandi
trianna
kim
surluk
valxion
Comparing first person(tony) and last person(valxion) name in lexical order
result : -2

*/
