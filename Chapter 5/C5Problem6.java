public final class C5Problem6 {
    private C5Problem6() {
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(29, 15));
    }

    static int hammingDistance(int a, int b) {
        int res = 0;
        int xor = a ^ b;
        while (xor != 0) {
            xor &= xor - 1;
            res++;
        }
        return res;
    }
}
