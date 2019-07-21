import structures.Tree;

import static structures.Tree.isBalanced;
import static structures.Tree.printTree;

public final class Problem4 {

    public static void main(String[] args) {
        final Tree t = new Tree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        final Tree t2 = new Tree(4);
        t2.setLeft(new Tree(2).setLeft(new Tree(1)).setRight(new Tree(3)));
        t2.setRight(new Tree(5).setRight(new Tree(6).setLeft(new Tree(7).setLeft(new Tree(9))).setRight(new Tree(8))));

        printTree(t2, 0);

        System.out.println(isBalanced(t));
        System.out.println(isBalanced(t2));
    }
}
