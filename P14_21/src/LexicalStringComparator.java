import java.util.Comparator;


public class LexicalStringComparator implements Comparator<String> 
{

	@Override
	public int compare(String o1, String o2) {
		int diff = o2.length() - o1.length();
		if(diff == 0)
			return o1.compareTo(o2); 
		// the standard method for compareTo is using lexical comparison
		return (diff > 0 ? -1 : 1);
	}

}
