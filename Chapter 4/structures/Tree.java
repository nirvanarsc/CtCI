package structures;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class Tree {
    private int distance;
    private int value;
    private Tree left, right;

    public Tree(int val) {
        this.value = val;
    }

    public Tree(@NotNull int[] arr) {

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

    public static List<LinkedList<Tree>> listDepths(Tree tree) {
        LinkedList<Tree> q = new LinkedList<>();
        Map<Integer, LinkedList<Tree>> map = new HashMap<>();

        tree.distance = 0;
        q.add(tree);
        map.put(tree.distance, new LinkedList<>(Collections.singletonList(tree)));

        Tree u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            addDepth(q, map, u.left, u.distance);
            addDepth(q, map, u.right, u.distance);
        }

        return new ArrayList<>(map.values());
    }

    public static boolean isBalanced(Tree root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static boolean validateBST(Tree root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.value > root.value) {
            return false;
        }
        if (root.right != null && root.right.value <= root.value) {
            return false;
        }
        return validateBST(root.left) && validateBST(root.right);
    }

    private static int checkHeight(Tree root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private static void addDepth(LinkedList<Tree> q, Map<Integer, LinkedList<Tree>> map, Tree u, int distance) {
        if (u != null) {
            q.add(u);
            u.distance = distance + 1;

            map.computeIfPresent(u.distance, (k, v) -> {
                v.add(u);
                return v;
            });

            map.putIfAbsent(u.distance, new LinkedList<>(Collections.singletonList(u)));
        }
    }

    @Override
    public String toString() {
        return Integer.toString(getValue());
    }
}
