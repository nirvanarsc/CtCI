public final class C5Problem3 {

    private C5Problem3() {
    }

    public static void main(String[] args) {
        System.out.println(flipBit(1775));
        System.out.println(flipBit(Integer.MAX_VALUE ^ Integer.MIN_VALUE));
    }

    static int flipBit(int a) {
        if (~a == 0) {
            return Integer.BYTES * 8;
        }
        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;
        while (a != 0) {
            if ((a & 1) == 1) {
                currentLength++;
            } else if ((a & 1) == 0) {
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }

            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            a >>>= 1;
        }
        return maxLength;
    }
}
