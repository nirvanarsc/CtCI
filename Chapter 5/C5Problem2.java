import static java.lang.Integer.toBinaryString;

public class C5Problem2 {

    public static void main(String[] args) {
        System.out.println(toBinaryString(875));
        System.out.println(printBinary(0.875));
    }

    private static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        double frac = 0.5;
        binary.append("0.");
        while (num > 0) {
            if (binary.length() > 32) {
                return "ERROR";
            }
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
}
