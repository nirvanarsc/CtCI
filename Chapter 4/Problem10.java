import structures.Tree;

import java.util.stream.IntStream;

public final class Problem10 {

    public static void main(String[] args) {
        final Tree t1 = new Tree(IntStream.range(1, 16).toArray());
        final Tree t2 = new Tree(IntStream.range(9, 12).toArray());

        Tree.printTree(t2, 0);
        System.out.println(checkSubTree(t1, t2));
    }

    private static boolean checkSubTree(Tree t1, Tree t2) {
        if (t1 == null) {
            return false;
        }

        if (t1.getValue() == t2.getValue()) {
            return compareTrees(t1, t2);
        }

        return checkSubTree(t1.getLeft(), t2) || checkSubTree(t1.getRight(), t2);
    }


    private static boolean compareTrees(Tree a, Tree b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null) {
            return a.getValue() == b.getValue()
                    && compareTrees(a.getLeft(), b.getLeft())
                    && compareTrees(a.getRight(), b.getRight());
        }
        return false;
    }
}
