/* CSC372 Critical Thinking #6, Storing an ArrayList
 * The Class provides a way to sort student objects based on their roll number.
 */
import java.util.Comparator;

public class RollnoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}
