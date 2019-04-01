import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to calculate the fibonacci sequence non-recursively until it hits a set limit of digits, e.g. calculating
 * until the first 1000 digit fibonacci is found
 */
public class Fibonacci {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static List<BigInteger> previousCalculations = new ArrayList<>();

    /**
     * This calculates the fibonacci sequence without using recursion, allowing for massive numbers very fast!
     *
     * @param n the next fibonacci to calculate
     * @return the calculated fibonacci
     */
    private static BigInteger fibonacciSequence(BigInteger n) {
        if (!(n.compareTo(TWO) < 0)) {
            int length = previousCalculations.size();
            return previousCalculations.get(length - 1).add(previousCalculations.get(length - 2));
        } else return n;
    }

    /**
     * This method finds the first fibonacci term that has digitAmount digits
     *
     * @param digitAmount the amount of digits you want to calculate up to
     * @return the index of this fibonacci, i.e. fib(index)
     */
    private static int indexOfFibonacci(int digitAmount) {
        BigInteger index = BigInteger.ZERO;
        BigInteger currentFib;
        int length = 0;
        while (length < digitAmount) {
            currentFib = fibonacciSequence(index);
            length = currentFib.toString().length();
            previousCalculations.add(currentFib);
            index = index.add(BigInteger.ONE);
        }
        return previousCalculations.size() - 1;
    }

    /**
     * The main method that parses the args and outputs the answer
     *
     * @param args digitAmount: the amount of digits you want to calculate (default 1000)
     */
    public static void main(String[] args) {

        int digitAmount = args.length == 1 ? Integer.parseInt(args[0]) : 1000;

        System.out.println(
                "The first fibonacci index with " +
                        digitAmount + (digitAmount == 1 ? " digit" : " digits") +
                        " is " +
                        "Fib(" + indexOfFibonacci(digitAmount) + ")");
    }

}
