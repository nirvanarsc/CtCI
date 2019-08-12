import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class C8Problem9 {

    public static void main(String[] args) {
        System.out.println(parens(4));
        System.out.println(generateParens(4));
    }

    static Set<String> parens(int n) {
        if (n == 1) {
            return new HashSet<>(Collections.singleton("()"));
        }

        final Set<String> res = new HashSet<>();

        for (String string : parens(n - 1)) {
            res.addAll(insertParens(string));
        }

        return res;
    }

    private static Set<String> insertParens(String s) {
        final Set<String> res = new HashSet<>();
        res.add(s + "()");
        res.add("()" + s);
        res.add('(' + s + ')');
        for (int i = 1; i < s.length(); i++) {
            res.add(s.substring(0, i) + "()" + s.substring(i));
        }
        return res;
    }

    static List<String> generateParens(int n) {
        final char[] str = new char[n * 2];
        final List<String> list = new ArrayList<>();
        addParen(list, n, n, str, 0);
        return list;
    }

    static void addParen(List<String> list, int left, int right, char[] str, int index) {
        if (left < 0 || right < left) {
            return;
        }

        if (left == 0 && right == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParen(list, left - 1, right, str, index + 1);

            str[index] = ')';
            addParen(list, left, right - 1, str, index + 1);
        }
    }

    private C8Problem9() {
    }
}
