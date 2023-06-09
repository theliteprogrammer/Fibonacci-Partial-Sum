import java.math.BigDecimal;
import java.math.BigInteger;
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
    private static BigInteger getFibonacciPartialSumFast(long from, long to) {
        BigInteger sum = BigInteger.valueOf(0);
        // create 1D array
        BigInteger[] array = new BigInteger[(int)to + 1];
        array[0] = BigInteger.valueOf(0);
        if(to >= 1){
            array[1] = BigInteger.valueOf(1);
        }
        for(int i = 2; i < array.length; i++){
            array[i] = array[i - 2].add(array[i - 1]);
        }
        for(int i = 0; i < array.length; i++){
            if(i >= from){
                sum = sum.add(array[i]);
            }
        }
        return sum.mod(BigInteger.valueOf(10));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}