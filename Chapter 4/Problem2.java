import structures.Tree;

public final class Problem2 {

    public static void main(String[] args) {
        final Tree bst = new Tree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        Tree.printTree(bst, 0);
    }
}
