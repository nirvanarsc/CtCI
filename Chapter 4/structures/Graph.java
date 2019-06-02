package structures;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Graph {
    public Node[] nodes;

    public enum State {
        Unvisited, Visited, Visiting
    }
}
