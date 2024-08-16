public class InsertionSort extends Sort {

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

        assert isSorted(items);
    }
}
