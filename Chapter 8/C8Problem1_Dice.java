import java.math.BigInteger;
import java.util.Arrays;

public final class C8Problem1_Dice {

    public static void main(String[] args) {
        System.out.println(diceGameImp(400));
        System.out.println(diceGame(400));
        System.out.println(numberOfCombinations(400));
        System.out.println(bottomUpDP(610, 6));
        System.out.println(diceGameImp(610));
    }

    // For K-sided dice
    private static BigInteger bottomUpDP(int n, int k) {
        final BigInteger[] dp = new BigInteger[k];
        Arrays.fill(dp, BigInteger.ZERO);
        dp[k - 1] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            final BigInteger temp = Arrays.stream(dp).reduce(BigInteger.ZERO, BigInteger::add);
            System.arraycopy(dp, 1, dp, 0, k - 1);
            dp[k - 1] = temp;
        }
        return dp[k - 1];
    }

    // My solution optimized for memory
    private static BigInteger diceGameImp(int n) {
        if (n <= 6) {
            return BigInteger.valueOf((int) Math.pow(2, n - 1));
        }

        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(2);
        BigInteger c = BigInteger.valueOf(4);
        BigInteger d = BigInteger.valueOf(8);
        BigInteger e = BigInteger.valueOf(16);
        BigInteger f = BigInteger.valueOf(32);

        for (int i = 7; i < n; i++) {
            final BigInteger next = a.add(b).add(c).add(d).add(e).add(f);
            a = b;
            b = c;
            c = d;
            d = e;
            e = f;
            f = next;
        }
        return a.add(b).add(c).add(d).add(e).add(f);
    }

    // My solution with memoization
    private static BigInteger diceGame(int n) {
        final BigInteger[] memo = new BigInteger[n + 1];
        Arrays.fill(memo, BigInteger.ZERO);
        return diceGame(n, memo);
    }

    private static BigInteger diceGame(int n, BigInteger[] memo) {
        if (n <= 6) {
            return BigInteger.valueOf((int) Math.pow(2, n - 1));
        }

        if (memo[n].equals(BigInteger.ZERO)) {
            for (int i = 1; i <= 6; i++) {
                memo[n] = memo[n].add(diceGame(n - i, memo));
            }
        }

        return memo[n];
    }

    // Different approach of memoization
    private static BigInteger numberOfCombinations(int max) {
        final BigInteger[] results = new BigInteger[max + 6];
        Arrays.fill(results, BigInteger.valueOf(0));
        results[0] = BigInteger.valueOf(1);
        for (int index = 0; index < max; index++) {
            for (int dieIndex = 1; dieIndex <= 6; dieIndex++) {
                results[index + dieIndex] = results[index + dieIndex].add(results[index]);
            }
        }
        return results[max];
    }
}
