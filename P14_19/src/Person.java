public class Person implements Comparable<Person> {

    private String name;

    public Person() {
        this.name = "";
    }

    public Person(String nameInput) {
        this.name = nameInput;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public int compareTo(Person other) {
		return this.name.compareTo(other.getName());
	}

}
