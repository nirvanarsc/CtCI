import structures.Tree;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static structures.Tree.getSuccessor;

public class Problem6 {

    public static void main(String[] args) {
        List<Tree> treeList = IntStream.range(1, 10).mapToObj(Tree::new).collect(Collectors.toList());

        Tree root = treeList.get(4);

        root.setLeft(treeList.get(2)).setRight(treeList.get(7));
        treeList.get(2).setParent(root).setLeft(treeList.get(1)).setRight(treeList.get(3));
        treeList.get(1).setParent(treeList.get(2)).setLeft(treeList.get(0));
        treeList.get(0).setParent(treeList.get(1));
        treeList.get(3).setParent(treeList.get(2));
        treeList.get(7).setParent(root).setLeft(treeList.get(6)).setRight(treeList.get(8));
        treeList.get(6).setParent(treeList.get(7)).setLeft(treeList.get(5));
        treeList.get(5).setParent(treeList.get(6));
        treeList.get(8).setParent(treeList.get(7));

        treeList.forEach(x -> System.out.println(x.getValue() + " " + getSuccessor(x)));
    }
}
