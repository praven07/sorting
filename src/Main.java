import java.util.Arrays;
import java.util.random.RandomGenerator;

public class Main {

    private static final RandomGenerator rg = RandomGenerator.getDefault();

    public static void main(String[] args) {

        Integer[] values = new Integer[10];

        for (int i = 0; i < values.length; i++) {
            values[i] = Main.rg.nextInt(1, 100);
        }

        System.out.println(Arrays.toString(values));

        InsertionSort.sort(values);

        System.out.println(Arrays.toString(values));
    }
}