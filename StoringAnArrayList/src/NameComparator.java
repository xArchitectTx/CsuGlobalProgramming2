/* CSC372 Critical Thinking #6, Storing an ArrayList
 * The Class implements a custom comparison logic to sort student objects by their name.
 */
import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
