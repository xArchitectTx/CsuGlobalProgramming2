/* CSC372 Critical Thinking #6, Storing an ArrayList
 * The Class represents a student with three attributes: roll number, name, and address.
 */
public class Student {
    private int rollno;
    private String name;
    private String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student [Roll# = " + rollno + ", Name = " + name + ", Address = " + address + "]";
    }
}
