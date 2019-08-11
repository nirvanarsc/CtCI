import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class C8Problem7 {

    public static void main(String[] args) {
        System.out.println(uniquePermutations("abcdef"));
    }

    static List<String> uniquePermutations(String s) {
        if (s.length() == 1) {
            return new ArrayList<>(Collections.singletonList(s));
        }

        final List<String> res = new ArrayList<>();

        for (String string : uniquePermutations(s.substring(0, s.length() - 1))) {
            res.addAll(insertChar(string, s.charAt(s.length() - 1)));
        }

        return res;
    }

    private static List<String> insertChar(String s, char c) {
        final List<String> res = new ArrayList<>();
        res.add(c + s);
        for (int i = 1; i < s.length(); i++) {
            res.add(s.substring(0, i) + c + s.substring(i));
        }
        res.add(s + c);
        return res;
    }

    private C8Problem7() {
    }
}
