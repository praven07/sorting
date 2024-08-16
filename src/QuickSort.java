import java.util.Arrays;
import java.util.random.RandomGenerator;

public class QuickSort extends Sort {

    private static final RandomGenerator rg = RandomGenerator.getDefault();

    public static void sort(Comparable[] items) {

        shuffle(items);
        sort(items, 0, items.length - 1);

        assert isSorted(items);
    }

    private static void sort(Comparable[] items, int lo, int hi) {

        if (hi > lo) {
            int j = partition(items, lo, hi);
            sort(items, lo, j - 1);
            sort(items, j + 1, hi);
        }
    }

    private static int partition(Comparable[] items, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        Comparable partition = items[lo];

        while (true) {

            while (less(items[++i], partition)) {
                if (i == hi) break;
            }

            while (less(partition, items[--j])) {
                if (j == lo) break;
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

    public static void main(String[] args) {

        Integer[] items = {8, 2, 2, 9, 3, 2, 5, 9, 4, 1};

        System.out.println(Arrays.toString(items));

        sort(items);

        if (!isSorted(items)) {
            System.out.println("Items not sorted");
        } else {
            System.out.println("Items are sorted");
        }

        System.out.println(Arrays.toString(items));
    }
}
