public class InsertionSort {

    public static void sort(Comparable[] items) {

       for (int i = 0; i < items.length; i++) {

           for (int j = i; j > 0; j--) {
               if (less(items[j], items[j - 1])) {
                   swap(items, j, j - 1);
               } else {
                   break;
               }
           }
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
