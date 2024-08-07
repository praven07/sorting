public class MergeSortBottomUp {

    public static void sort(Comparable[] items) {

        Comparable[] aux = new Comparable[items.length];

        int n = items.length;

        for (int size = 1; size < n; size = size * 2) {

            for (int low = 0; low < n - size; low += size * 2) {
                int mid = low + size - 1;
                int high = Math.min(low + (size * 2) - 1, n - 1);
                merge(items, aux, low, mid, high);
            }
        }

        assert isSorted(items);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] items, Comparable[] aux, int low, int mid, int high) {

        for (int k = low; k <= high; k++) {
            aux[k] = items[k];
        }

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {

            if (i > mid) {
                items[k] = aux[j++];
            } else if (j > high) {
                items[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                items[k] = aux[i++];
            } else {
                items[k] = aux[j++];
            }
        }
    }

    private static boolean isSorted(Comparable[] items) {

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
