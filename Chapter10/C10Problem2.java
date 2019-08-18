import java.util.Arrays;
import java.util.Comparator;

public class C10Problem2 {

    private static void sortByAnagrams(String[] strings) {
        Arrays.sort(strings, Comparator.comparing(C10Problem2::sortChars));
    }

    private static String sortChars(String s) {
        final char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
