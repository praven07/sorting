public abstract class Sort {

    /**
     * Compares if 'a' is less than 'b'
     * @param a
     * @param b
     * @return
     */
    protected static boolean less(Comparable a, Comparable b) {

        return a.compareTo(b) < 0;
    }

    /**
     * Swaps items at index 'i' and 'j'
     * @param items
     * @param i
     * @param j
     */
    protected static void swap(Comparable[] items, int i, int j) {

        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * Check to see if an array of items is in sorted order.
     * @param items
     * @return true if the list is sorted.
     */
    public static boolean isSorted(Comparable[] items) {

        if (items.length <= 1) {
            return true;
        }

        for (int i = 1; i < items.length; i++) {
            if (less(items[i], items[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
