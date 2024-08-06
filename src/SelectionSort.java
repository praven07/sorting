public class SelectionSort {

    public static void sort(Comparable[] items) {

        for (int i = 0; i < items.length; i++) {

           int min = i;

           for (int j = i; j < items.length; j++) {
               if (less(items[j], items[min])) {
                   min = j;
               }
           }

           swap(items, i, min);
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
