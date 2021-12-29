import java.util.HashMap;
import java.util.Map;

public class DeepFirstSearch {
    public static void main(String []args) {
        Graph graph = initGraph();

        // Starting the algorithm
        // Mark all the vertices as not visited
        Map<String, Boolean> visited = new HashMap<>();
        Integer time = 0;

        for (String vertex : graph.getVertices()) {
            if (!visited.getOrDefault(vertex, false)) {
                time = dfsVisit(graph, vertex, visited, time);
            }
        }
    }

    public static Integer dfsVisit(Graph graph, String initVertex, Map<String, Boolean> visited, Integer time) {
        visited.put(initVertex, true);
        time = time + 1;
        System.out.println("Init vertex: " + initVertex + " | Finding: "+ time);
        for (String vertex : graph.getNeighbors(initVertex)) {
            if (!visited.getOrDefault(vertex, false)) {
                time = dfsVisit(graph, vertex, visited, time);
            }
        }
        time = time + 1;
        System.out.println("Init vertex: " + initVertex + " | Ending: "+ time);
        return time;
    }

    private static Graph initGraph() {
        Graph graph = new Graph(true);

        graph.addVertex("u");
        graph.addVertex("v");
        graph.addVertex("w");
        graph.addVertex("x");
        graph.addVertex("y");
        graph.addVertex("z");

        graph.addEdge("u", "v", 1);
        graph.addEdge("u", "x", 1);
        graph.addEdge("v", "y", 1);
        graph.addEdge("y", "x", 1);
        graph.addEdge("x", "v", 1);
        graph.addEdge("w", "y", 1);
        graph.addEdge("w", "z", 1);
        graph.addEdge("z", "z", 1);
        return graph;
    }
}
