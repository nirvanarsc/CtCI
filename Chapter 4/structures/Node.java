package structures;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import structures.Graph.State;

@Getter
@Setter
@RequiredArgsConstructor
public class Node {
    private final String name;
    private Node[] adjacent;
    private State state;
}