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
        System.out.println();

        // Book solution
        final int width = 8;
        final int height = 1;
        for (int r = 0; r < height; r++) {
            for (int c1 = 0; c1 < width; c1++) {
                for (int c2 = c1; c2 < width; c2++) {
                    final byte[] screen = new byte[width * height / 8];

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    drawLine2(screen, width, c1, c2, r);
                    printScreen(screen, width);
                    System.out.println();
                }
            }
        }
    }

    static byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
        final int height = screen.length / width;
        final int lineHeight = height - y - 1;
        for (int i = lineHeight * width + x1; i < lineHeight * width + x2; i++) {
            screen[i] = (byte) 0xFF;
        }
        return screen;

    }

    public static void drawLine2(byte[] screen, int width, int x1, int x2, int y) {
        final int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }

        final int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }

        // Set full bytes
        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        final byte start_mask = (byte) (0xFF >> start_offset);
        final byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
            final byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                final int byte_number = (width / 8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (end_offset != 7) {
                final int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    public static void printByte(byte b) {
        for (int i = 7; i >= 0; i--) {
            final char c = ((b >> i) & 1) == 1 ? '1' : '_';
            System.out.print(c);
        }
    }

    public static int computeByteNum(int width, int x, int y) {
        return (width * y + x) / 8;
    }

    public static void printScreen(byte[] screen, int width) {
        final int height = screen.length * 8 / width;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c += 8) {
                final byte b = screen[computeByteNum(width, c, r)];
                printByte(b);
            }
            System.out.println();
        }
    }
}
