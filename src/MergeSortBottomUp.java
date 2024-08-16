public class MergeSortBottomUp extends Sort {

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
}
