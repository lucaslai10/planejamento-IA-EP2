package problem;

import java.util.HashMap;
import java.util.List;

public class Action {

    private String name;
    private List<Edge> edges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Action() {
    }

    public Action(String name, List<Edge> edges) {
        this.name = name;
        this.edges = edges;
    }
}
