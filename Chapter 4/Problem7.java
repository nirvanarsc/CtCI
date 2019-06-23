import structures.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Problem7 {
    public static void main(String[] args) {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = new String[][]{
                new String[]{"a", "d"},
                new String[]{"f", "b"},
                new String[]{"b", "d"},
                new String[]{"f", "a"},
                new String[]{"d", "c"}
        };

        getBuildOrder(projects, dependencies);
    }

    private static void getBuildOrder(String[] projects, String[][] dependencies) {
        Map<String, Node> nodes = new HashMap<>();
        for (String project : projects) {
            nodes.put(project, new Node(project));
        }
        for (String[] dependency : dependencies) {
            nodes.get(dependency[0]).addAdjacent(nodes.get(dependency[1]));
            nodes.get(dependency[0]).inDegree++;
        }

        LinkedList<Node> order = new LinkedList<>();
        LinkedList<Node> processNext = new LinkedList<>();

        nodes.forEach((x, y) -> {
            if(y.inDegree == 0) {
                processNext.add(y);
            }
        });

        while(!processNext.isEmpty()) {
            Node node = processNext.pop();
            if(node.getAdjacent() != null) {
                for (Node n : node.getAdjacent()) {
                    n.inDegree--;
                    if (n.inDegree == 0) {
                        processNext.add(n);
                        order.add(n);
                    }
                }
            } else order.add(node);
        }

        order.forEach(x -> System.out.println(x.getName()));



    }
}
