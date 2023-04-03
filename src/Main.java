import java.util.Scanner;

public class Main {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    /**
     *
     * @param from - Starting term
     * @param to - Ending term
     * @return The remainder of the sum of fibonacci numbers in the range:  from-to divided by 10
     */
    private static long getFibonacciPartialSumFast(long from, long to) {
        long sum = 0;
        // create 1D array
        long[] array = new long[(int)to + 1];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i < array.length; i++){
            if(i >= from){
                sum += array[i];
            }
            array[i] = array[i - 2] + array[i - 1];
        }
        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}