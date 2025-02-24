/*




 */
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Student objects.
        ArrayList<Student> students = new ArrayList<>();

        // Add 10 Student objects.
        students.add(new Student(10, "Ragnar", "2518 Viking St"));
        students.add(new Student(3, "Bjorn", "4397 Odin St"));
        students.add(new Student(7, "Ivar", "7896 Valhalla St"));
        students.add(new Student(2, "Astrid", "1011 West Hedeby St"));
        students.add(new Student(5, "Helga", "2212 Novgorod St"));
        students.add(new Student(9, "Gyda", "1313 East Kattegat St"));
        students.add(new Student(1, "Lagertha", "6404 Shield-Maiden St"));
        students.add(new Student(6, "Floki", "5065 The Boatmaker St"));
        students.add(new Student(4, "Rollo", "6006 Normandy St"));
        students.add(new Student(8, "Seer", "5707 Old Norse St"));

        // Display the unsorted list.
        System.out.println("Original list:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by name using the NameComparator.
        System.out.println("\nSorting by name:");
        SelectionSort.selectionSort(students, new NameComparator());
        for (Student s : students) {
            System.out.println(s);
        }

        // Now, sort by roll number using the RollnoComparator.
        System.out.println("\nSorting by roll number:");
        SelectionSort.selectionSort(students, new RollnoComparator());
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
