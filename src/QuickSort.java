import java.util.Arrays;
import java.util.random.RandomGenerator;

public class QuickSort {

    private static final RandomGenerator rg = RandomGenerator.getDefault();

    public static void sort(Comparable[] items) {

        shuffle(items);
        sort(items, 0, items.length - 1);
    }

    private static void sort(Comparable[] items, int lo, int hi) {

        if (hi > lo) {
            int j = partition(items, lo, hi);
            sort(items, lo, j - 1);
            sort(items, j + 1, hi);
        }
    }

    private static int partition(Comparable[] items, int lo, int hi) {

        int i = lo + 1;
        int j = hi;

        Comparable partition = items[lo];

        while (true) {

            while (less(items[i], partition) && i < hi) {
                i++;
            }

            while (less(partition, items[j]) && j > lo) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(items, i, j);
        }

        swap(items, lo, j);

        return j;
    }

    private static void shuffle(Comparable[] items) {

        for (int i = 0; i < items.length; i++) {

            int j = rg.nextInt(i, items.length);
            swap(items, i, j);
        }
    }

    private static void swap(Comparable[] items, int i, int j) {

        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
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

    public static void main(String[] args) {

        Integer[] items = new Integer[100];

        for (int i = 0; i < items.length; i++) {
            items[i] = rg.nextInt();
        }

        sort(items);

        if (!isSorted(items)) {
            System.out.println("Items not sorted");
        } else {
            System.out.println("Items are sorted");
        }

        System.out.println(Arrays.toString(items));
    }
}
