public final class C8Problem5 {

    public static void main(String[] args) {
        System.out.println(mul(4432, 4321));
        System.out.println(mul2(4432, 4321));
    }

    private static int mul(int a, int b) {
        return mul(a, b, new int[a + 1]);
    }

    private static int mul(int a, int b, int[] cache) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        final int t = a;
        a >>= 1;
        if (cache[a] == 0) {
            cache[a] = mul(a, b, cache);
        }
        if ((t & 1) == 1) {
            return b + cache[a] + cache[a];
        }
        return cache[a] + cache[a];
    }

    private static int mul2(int a, int b) {
        final int bigger = Math.max(a, b);
        final int smaller = Math.min(a, b);
        return mul2Helper(smaller, bigger);
    }

    private static int mul2Helper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        }
        if (smaller == 1) {
            return bigger;
        }

        final int half = smaller >> 1;
        final int halfProduct = mul2Helper(half, bigger);

        if ((smaller & 1) == 1) {
            return bigger + halfProduct + halfProduct;
        }

        return halfProduct + halfProduct;
    }
}
