package structures;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import structures.Graph.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Node {
    private final String name;
    private Node[] adjacent;
    private State state;
    public int outDegree;
    public int inDegree;

    public void addAdjacent(Node n) {
        if (adjacent == null) {
            adjacent = new Node[]{n};
            return;
        }

        final List<Node> nodes = new ArrayList<>(Arrays.asList(adjacent));
        nodes.add(n);
        adjacent = nodes.toArray(adjacent);
    }

    @Override
    public String toString() {
        return name + outDegree + inDegree;
    }
}
