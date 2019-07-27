public final class C5Problem8 {

    private C5Problem8() {
    }

    public static void main(String[] args) {
        final byte[] arr = new byte[80];
        int row = 0;
        for (byte b : drawLine(arr, 8, 1, 7, 2)) {
            System.out.print(b + " ");
            row++;
            if (row % 8 == 0) {
                System.out.println();
            }
        }

    }

    static byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
        final int height = screen.length / width;
        final int lineHeight = height - y - 1;
        for (int i = lineHeight * width + x1; i < lineHeight * width + x2; i++) {
            screen[i] = (byte)0xFF;
        }
        return screen;

    }
}
