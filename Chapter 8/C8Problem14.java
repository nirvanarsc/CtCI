import java.util.HashMap;
import java.util.Map;

public final class C8Problem14 {

    public static void main(String[] args) {
        System.out.println(countEval("1^0|0|1", false));
        System.out.println(countEval2("1^0|0|1", false));

        long curr = System.currentTimeMillis();
        System.out.println(countEval("0&0&0&1^1|0&0&0&1^1|0&0&0", true));
        System.out.println("Recursive finished in " + (System.currentTimeMillis() - curr) + " ms.");

        curr = System.currentTimeMillis();
        System.out.println(countEval2("0&0&0&1^1|0&0&0&1^1|0&0&0", true));
        System.out.println("Memoization finished in " + (System.currentTimeMillis() - curr) + " ms.");
    }

    static int countEval(String s, boolean result) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return stringToBool(s) == result ? 1 : 0;
        }
        int ways = 0;
        for (int i = 1; i < s.length(); i += 2) {
            final char c = s.charAt(i);
            final String left = s.substring(0, i);
            final String right = s.substring(i + 1);

            final int leftTrue = countEval(left, true);
            final int leftFalse = countEval(left, false);
            final int rightTrue = countEval(right, true);
            final int rightFalse = countEval(right, false);
            ways += getSubways(result, c, leftTrue, leftFalse, rightTrue, rightFalse);
        }

        return ways;
    }

    static int countEval2(String s, boolean result) {
        return countEval2(s, result, new HashMap<>(), new HashMap<>());
    }

    static int countEval2(String s, boolean result, Map<String, Integer> trueMap, Map<String, Integer> falseMap) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return stringToBool(s) == result ? 1 : 0;
        }
        int ways = 0;
        for (int i = 1; i < s.length(); i += 2) {
            final char c = s.charAt(i);
            final String left = s.substring(0, i);
            final String right = s.substring(i + 1);

            final int leftTrue = trueMap.computeIfAbsent(left, k -> countEval2(left, true, trueMap, falseMap));
            final int leftFalse = falseMap.computeIfAbsent(left, k -> countEval2(left, false, trueMap, falseMap));
            final int rightTrue = trueMap.computeIfAbsent(right, k -> countEval2(right, true, trueMap, falseMap));
            final int rightFalse = falseMap.computeIfAbsent(right, k -> countEval2(right, false, trueMap, falseMap));

            ways += getSubways(result, c, leftTrue, leftFalse, rightTrue, rightFalse);
        }

        return ways;
    }

    private static int getSubways(boolean result, char c, int leftTrue, int leftFalse, int rightTrue, int rightFalse) {
        final int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
        final int totalTrue;

        if (c == '^') {
            totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
        } else if (c == '&') {
            totalTrue = leftTrue * rightTrue;
        } else {
            totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
        }

        return result ? totalTrue : total - totalTrue;
    }

    private static boolean stringToBool(String c) {
        return "1".equals(c);
    }

    private C8Problem14() {
    }
}
