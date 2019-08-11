import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class C8Problem8 {

    public static void main(String[] args) {
        System.out.println(uniquePermutations("aaaaaaaaaaaaab"));
    }

    static Set<String> uniquePermutations(String s) {
        if (s.length() == 1) {
            return new HashSet<>(Collections.singleton(s));
        }

        final Set<String> res = new HashSet<>();

        for (String string : uniquePermutations(s.substring(0, s.length() - 1))) {
            res.addAll(insertChar(string, s.charAt(s.length() - 1)));
        }

        return res;
    }

    private static Set<String> insertChar(String s, char c) {
        final Set<String> res = new HashSet<>();
        res.add(c + s);
        for (int i = 1; i < s.length(); i++) {
            res.add(s.substring(0, i) + c + s.substring(i));
        }
        res.add(s + c);
        return res;
    }

    private C8Problem8() {
    }
}
