import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// https://stackoverflow.com/questions/7153659/find-an-integer-not-among-four-billion-given-ones
public class C10Problem7 {

    int radix = 8;
    byte[] bitfield = new byte[0xffffffff / radix];

    void findOpenNurnber() throws FileNotFoundException {
        final Scanner in = new Scanner(new FileReader("filename.txt"));
        while (in.hasNextInt()) {
            final int n = in.nextInt();
            bitfield[n / radix] |= 1 << (n % radix);
        }

        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < radix; j++) {
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println(i * radix + j);
                }
            }
        }
    }
}
