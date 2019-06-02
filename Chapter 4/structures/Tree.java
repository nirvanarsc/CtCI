package structures;

import java.util.Arrays;

public class Tree {
    private int value;
    private Tree left, right;

    public Tree(int[] arr) {

        if (arr.length == 0) {
            return;
        }
        int middleIndex = arr.length / 2;
        this.value = arr[middleIndex];

        if (middleIndex == 0) {
            return;
        }

        this.left = new Tree(Arrays.copyOfRange(arr, 0, middleIndex));
        if (middleIndex == arr.length - 1) {
            return;
        }

        this.right = new Tree(Arrays.copyOfRange(arr, middleIndex + 1, arr.length));
    }

    public static void printTree(Tree tree, int level) {
        if (tree != null) {
            printTree(tree.left, level + 1);
            System.out.println(tree.value + " at level " + level);
            printTree(tree.right, level + 1);
        }
    }
}
