import java.util.LinkedList;

public class Problem1 {

    private static boolean search(Graph g, Node start, Node end) {
        if (start == end) {
            return true;
        }

        LinkedList<Node> q = new LinkedList<>();

        for (Node u : g.nodes) {
            u.setState(Node.State.Unvisited);
        }

        start.setState(Node.State.Visiting);
        q.add(start);

        Node u;

        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.getState() == Node.State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.setState(Node.State.Visiting);
                            q.add(v);
                        }
                    }
                }
                u.setState(Node.State.Visited);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        Node n4 = new Node("n4");
        Node n5 = new Node("n5");
        Node n6 = new Node("n6");

        n1.setAdjacent(new Node[]{n2, n3, n4});
        n2.setAdjacent(new Node[]{n1});
        n3.setAdjacent(new Node[]{n1});
        n4.setAdjacent(new Node[]{n1, n5});
        n5.setAdjacent(new Node[]{n4, n6});
        n6.setAdjacent(new Node[]{n5});

        Graph g = new Graph(new Node[]{n1, n2, n3, n4, n5, n6});

        System.out.println(search(g, n2, n6));
    }
}
