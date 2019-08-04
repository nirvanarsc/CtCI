import java.util.Arrays;

final class C8Problem1 {

    private C8Problem1() {
    }

    public static void main(String[] args) {
        System.out.println(numSteps(36));
        System.out.println(numStepsMem(36));
        System.out.println(countWays(36));
    }

    // My solution optimized for memory
    static int numSteps(int n) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        int a = 1;
        int b = 2;
        int c = 4;
        for (int i = 4; i < n; i++) {
            final int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        return a + b + c;
    }

    // My solution with memoization
    static int numStepsMem(int n) {
        return numSteps(n, new int[n + 1]);
    }

    static int numSteps(int n, int[] memo) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        if (memo[n] == 0) {
            memo[n] = numSteps(n - 3, memo) + numSteps(n - 2, memo) + numSteps(n - 1, memo);
        }
        return memo[n];
    }

    // Book solution
    static int countWays(int n) {
        final int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
            return memo[n];
        }
    }
}
