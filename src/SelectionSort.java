public class SelectionSort extends Sort {

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

        assert isSorted(items);
    }
}
