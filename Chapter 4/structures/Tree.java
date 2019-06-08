package structures;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
public class Tree {
    private int distance;
    private int value;
    private Tree left, right;


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
        return Integer.toString(this.getValue());
    }
}
