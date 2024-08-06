public class InsertionSort {

    public static void sort(Comparable[] items) {

    }

    private static boolean less(Comparable a, Comparable b) {

        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] items, int i, int j) {

        Comparable temp = items[i];
        items[j] = items[i];
        items[i] = temp;
    }
}
