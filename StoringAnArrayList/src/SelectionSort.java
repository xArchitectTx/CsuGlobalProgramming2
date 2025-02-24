import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
    // Generic selection sort method that sorts an ArrayList using the provided comparator.
    public static <T> void selectionSort(ArrayList<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the element at index i.
            T temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }
}
