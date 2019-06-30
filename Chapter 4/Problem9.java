import structures.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem9 {
    public static void main(String[] args) {
        Tree tree = new Tree(IntStream.range(1, 8).toArray());

        allSequences(tree).forEach(System.out::println);
        System.out.println(allSequences(tree).size());
    }


    private static List<LinkedList<Integer>> allSequences(Tree tree) {
        List<LinkedList<Integer>> res = new ArrayList<>();

        if (tree == null) {
            res.add(new LinkedList<>());
            return res;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(tree.getValue());

        List<LinkedList<Integer>> left = allSequences(tree.getLeft());
        List<LinkedList<Integer>> right = allSequences(tree.getRight());

        for (LinkedList<Integer> l : left) {
            for (LinkedList<Integer> r : right) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(l, r, weaved, prefix);
                res.addAll(weaved);
            }
        }

        return res;
    }

    private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, List<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
