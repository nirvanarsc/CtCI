import structures.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

        getBuildOrder(projects, dependencies).forEach(node -> System.out.println(node.getName()));
    }

    private static List<Node> getBuildOrder(String[] projects, String[][] dependencies) {
        Map<String, Node> nodes = new HashMap<>();
        for (String project : projects) {
            nodes.put(project, new Node(project));
        }
        for (String[] dependency : dependencies) {
            nodes.get(dependency[0]).addAdjacent(nodes.get(dependency[1]));
            nodes.get(dependency[1]).outDegree++;
            nodes.get(dependency[0]).inDegree++;
        }

        LinkedList<Node> order = new LinkedList<>();
        LinkedList<Node> processNext = new LinkedList<>();

        nodes.forEach((x, y) -> {
            if (y.outDegree == 0) {
                processNext.add(y);
            }
        });

        while (!processNext.isEmpty()) {
            Node node = processNext.pop();
            if (node.getAdjacent() != null) {
                for (Node n : node.getAdjacent()) {
                    n.outDegree--;
                    if (n.outDegree == 0) {
                        processNext.add(n);
                    }
                }
            }
            order.add(node);
        }

        if (order.size() != nodes.size()) {
            throw new RuntimeException("Graph contains a cycle");
        }
        return order;
    }
}
