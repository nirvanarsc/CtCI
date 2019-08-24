import java.util.Arrays;
import java.util.Comparator;

public class C10Problem2 {

    private static void sortByAnagrams(String[] strings) {
        final Comparator<String> stringComparator1 = (s1, s2) -> sortChars(s1).compareTo(sortChars(s2));
        final Comparator<String> stringComparator2 = Comparator.comparing(s -> sortChars(s));
        final Comparator<String> stringComparator3 = Comparator.comparing(C10Problem2::sortChars);
        Arrays.sort(strings, stringComparator1);
    }

    private static String sortChars(String s) {
        final char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
