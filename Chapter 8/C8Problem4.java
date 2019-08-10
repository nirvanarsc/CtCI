import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class C8Problem4 {

    public static void main(String[] args) {
        final int n = 5;
        final Set<Set<Integer>> powerSet = powerSet(n);
        powerSet.forEach(System.out::println);
        System.out.println(powerSet.size());
        System.out.println();
        final List<List<Integer>> binary = getSubsets(IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList()));
        binary.forEach(System.out::println);
        System.out.println(binary.size());
    }

    static Set<Set<Integer>> powerSet(int n) {
        if (n == 0) {
            return Collections.emptySet();
        }

        final Set<Set<Integer>> res = new HashSet<>();
        res.add(Collections.emptySet());
        res.add(new HashSet<>(Collections.singleton(1)));

        if (n == 1) {
            return res;
        }

        for (int i = 2; i <= n; i++) {
            final Set<Set<Integer>> copy = new HashSet<>();
            for (Set<Integer> set : res) {
                final Set<Integer> singleCopy = new HashSet<>(set);
                singleCopy.add(i);
                copy.add(singleCopy);
            }
            res.addAll(copy);
        }

        return res;
    }

    static List<List<Integer>> getSubsets(List<Integer> set) {
        final List<List<Integer>> res = new ArrayList<>();
        final int max = 1 << set.size();
        for (int k = 0; k < max; k++) {
            final List<Integer> subset = convertIntToSet(k, set);
            res.add(subset);
        }
        return res;
    }

    static List<Integer> convertIntToSet(int x, List<Integer> set) {
        final List<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    private C8Problem4() {
    }
}
