import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Graph {
    public Node[] nodes;
}

@Getter
@Setter
@RequiredArgsConstructor
class Node {
    enum State {
        Unvisited, Visited, Visiting
    }

    private final String name;
    private Node[] adjacent;
    private State state;
}
