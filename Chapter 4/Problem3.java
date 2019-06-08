import structures.Tree;

import static structures.Tree.listDepths;

public class Problem3 {

    public static void main(String[] args) {
        Tree t = new Tree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        listDepths(t).forEach(System.out::println);
    }
}
