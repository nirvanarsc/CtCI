import static java.lang.Long.toBinaryString;

public class C5Problem2 {

    public static void main(String[] args) {
        System.out.println(fractionalToBinary(0.72, 64));
        System.out.println(fractionalToBinary2(0.72, 64));
        System.out.println(toBinaryString(Double.doubleToLongBits(0.72)));
    }

    private static String fractionalToBinary(double num, int precision) {
        final StringBuilder binary = new StringBuilder();
        double frac = 0.5;
        while (num > 0 && binary.length() < precision) {
            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }
            frac /= 2;
        }
        return binary.toString();
    }

    private static String fractionalToBinary2(double num, int precision) {
        final StringBuilder binary = new StringBuilder();
        while (num > 0 && binary.length() < precision) {
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
}
