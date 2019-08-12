import java.util.HashMap;
import java.util.Map;

public final class C8Problem11 {

    static final Map<Integer, Integer> COINS = new HashMap<>();

    static {
        COINS.put(1, 1);
        COINS.put(2, 5);
        COINS.put(3, 10);
        COINS.put(4, 25);
    }

    public static void main(String[] args) {
        long curr = System.currentTimeMillis();
        System.out.println(coinChange(1000));
        System.out.println(System.currentTimeMillis() - curr);

        curr = System.currentTimeMillis();
        System.out.println(makeChange(1000));
        System.out.println(System.currentTimeMillis() - curr);
    }

    static int coinChange(int n) {
        return coinChange(n, COINS.size());
    }

    static int coinChange(int n, int coinType) {
        if (n < 0 || coinType == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        return coinChange(n, coinType - 1) + coinChange(n - COINS.get(coinType), coinType);
    }

    static int makeChange(int n) {
        final int[] denoms = {25, 10, 5, 1};
        final int[][] map = new int[n + 1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    static int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) {
            return map[amount][index];
        }
        if (index >= denoms.length - 1) {
            return 1;
        }
        final int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            final int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    private C8Problem11() {
    }
}
