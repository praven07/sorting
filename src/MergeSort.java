public class MergeSort extends Sort {

    public static void sort(Comparable[] items) {

        Comparable[] aux = new Comparable[items.length];
        sort(items, aux, 0, items.length - 1);
        assert isSorted(items);
    }

    private static void sort(Comparable[] items, Comparable[] aux, int low, int high) {

        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(items, aux, low, mid);
            sort(items, aux, mid + 1, high);
            merge(items, aux, low, mid, high);
        }
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
            } else if (less(aux[j], aux[i])) {
                items[k] = aux[j++];
            } else {
                items[k] = aux[i++];
            }
        }
    }
}
