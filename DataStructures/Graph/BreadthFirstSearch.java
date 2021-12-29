import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class BreadthFirstSearch {
    public static void main(String []args) {
        Graph graph = initGraph();
        String initialVertex = "3";

        // Starting the algorithm
        // Mark all the vertices as not visited
        Map<String, Boolean> visited = new HashMap<>();
        Queue<String> vertices = new LinkedList<>();

        vertices.add(initialVertex);
        visited.put(initialVertex, true);
        while(!vertices.isEmpty()) {
            String currentVertex = vertices.poll();
            System.out.println(currentVertex);
            Set<String> neighbors = graph.getNeighbors(currentVertex);
            for (String neighbor : neighbors){
                if(!visited.containsKey(neighbor)) {
                  visited.put(neighbor, true);
                  vertices.add(neighbor);
                }
            }
        }
    }

    private static Graph initGraph() {
        Graph graph = new Graph(false);

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addVertex("8");

        graph.addEdge("1", "2", 1);
        graph.addEdge("2", "3", 1);
        graph.addEdge("3", "4", 1);
        graph.addEdge("4", "5", 1);
        graph.addEdge("4", "6", 1);
        graph.addEdge("5", "6", 1);
        graph.addEdge("5", "7", 1);
        graph.addEdge("5", "8", 1);
        graph.addEdge("6", "8", 1);
        graph.addEdge("7", "8", 1);
        return graph;
    }
}
