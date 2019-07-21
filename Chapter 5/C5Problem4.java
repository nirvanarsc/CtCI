import static java.lang.Integer.toBinaryString;

public final class C5Problem4 {

    private C5Problem4() {
    }

    public static void main(String[] args) {
        System.out.println("Next smallest number for \t" + toBinaryString(13948) + " is " + toBinaryString(nextSmallest(13948)) + ' ' + nextSmallest(13948));
        System.out.println("Next smallest number for \t" + toBinaryString(13948) + " is " + toBinaryString(getPrev(13948)) + ' ' + getPrev(13948));
        System.out.println("Next largest number for \t" + toBinaryString(13948) + " is " + toBinaryString(nextLargest(13948)) + ' ' + nextLargest(13948));
        System.out.println("Next largest number for \t" + toBinaryString(13948) + " is " + toBinaryString(getNext(13948)) + ' ' + getNext(13948));
        System.out.println();
        System.out.println("Next smallest number for \t" + toBinaryString(~0 << 5) + " is " + toBinaryString(nextSmallest(~0 << 5)));
        try {
            nextLargest(~0 << 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static int nextSmallest(int num) {
        int zeroIdx = 0;
        int oneIdx = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            if (!getBit(num, i)) {
                zeroIdx = i;
                break;
            }
        }
        for (int i = 0; i < Integer.SIZE; i++) {
            if (getBit(num, i)) {
                oneIdx = i;
                break;
            }
        }
        num = clearBit(num, oneIdx);
        num = setBit(num, zeroIdx);
        return num;
    }

    static int nextLargest(int num) {
        int zeroIdx = 0;
        boolean seenOne = false;
        for (int i = 0; i < Integer.SIZE; i++) {
            if (!getBit(num, i) && seenOne) {
                zeroIdx = i;
                break;
            } else if (getBit(num, i)) {
                seenOne = true;
            }
        }
        if (zeroIdx == 0) {
            throw new IllegalArgumentException("There is no larger number with the same number of 1s. for number:\n" + toBinaryString(num));
        }
        num = clearBit(num, zeroIdx - 1);
        num = setBit(num, zeroIdx);
        return num;
    }

    private static int clearBit(int num, int i) {
        num &= ~(1 << i);
        return num;
    }

    private static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    private static int setBit(int num, int i) {
        return num | (1 << i);
    }

    // Book solution.
    static int getNext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        final int p = c0 + c1;
        n |= 1 << p;
        n &= -(1 << p);
        n |= (1 << (c1 - 1)) - 1;

        return n;
    }

    // Book solution.
    static int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        if (temp == 0) {
            return -1;
        }

        while (((temp & 1) == 0) && temp != 0) {
            c0++;
            temp >>= 1;
        }

        final int p = c0 + c1;
        n &= ~0 << (p + 1);

        final int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);
        return n;
    }
}
