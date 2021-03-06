import structures.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static structures.Tree.getSuccessor;
import static structures.Tree.toList;

public final class Problem6 {

    public static void main(String[] args) {
        final Tree tree = new Tree(IntStream.range(1, 10).toArray());
        final List<Tree> treeList = toList(tree, new ArrayList<>());
        treeList.sort(Comparator.comparing(Tree::getValue));
        treeList.forEach(x -> System.out.println(x.getValue() + " " + getSuccessor(x)));
    }
}
