public class Student implements Comparable<Student> {

	private String firstName;
	private String lastName;
	private int studentId;
	static private int idGenerator = 0;
	

	public Student(String inFirstName, String inLastName) {
		firstName = inFirstName;
		lastName = inLastName;
		studentId = ++idGenerator;
	}

	/*
	 * This function defines the natural order or Student object
	 * @see Comparable#compareTo(java.lang.Object)
	 */
    @Override
    public int compareTo(Student other) {
    	// sort by last name is priority
        int comparingLastName = this.lastName.compareTo(other.lastName);
		if(comparingLastName != 0) return comparingLastName;

        int comparingFirstName = this.firstName.compareTo(other.firstName);
        if(comparingFirstName != 0) return comparingFirstName;
        return other.studentId - this.studentId;
    }

    @Override
    public String toString() {
    	return lastName + ", " + firstName;
//    	return firstName;
    }
}
