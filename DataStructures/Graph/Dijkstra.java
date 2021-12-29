import java.util.PriorityQueue;
import java.util.Queue;


public class Dijkstra {
    public static void main(String []args) {
        Graph graph = initGraph();
        String initialVertexKey = "s";

        // Starting the algorithm
        // Mark all the vertices as not visited
        Queue<Vertex> vertices = new PriorityQueue<>();
        Vertex initialVertex = graph.getNeighborAsVertex(initialVertexKey);
        initialVertex.setVisited(true);
        initialVertex.setDistance((double) 0);

        vertices.add(initialVertex);
        while(!vertices.isEmpty()) {
            Vertex currentVertex = vertices.poll();
            currentVertex.setVisited(true);

            for (String neighbor : graph.getNeighbors(currentVertex.getKey())) {
                Vertex neighborVertex = graph.getNeighborAsVertex(neighbor);
                if (!neighborVertex.getVisited()) {
                    Integer weight = graph.getWeight(currentVertex.getKey(), neighbor);
                    // relaxation
                    if (neighborVertex.getDistance() > currentVertex.getDistance() + weight) {
                        neighborVertex.setDistance(currentVertex.getDistance() + weight);
                        vertices.add(neighborVertex);
                    }
                }

            }
        }

        for (String v : graph.getVertices()) {
            System.out.println(graph.getNeighborAsVertex(v));
        }
    }

    private static Graph initGraph() {
        Graph graph = new Graph(true);

        graph.addVertex("s");
        graph.addVertex("t");
        graph.addVertex("x");
        graph.addVertex("y");
        graph.addVertex("z");

        graph.addEdge("s", "t", 10);
        graph.addEdge("s", "y", 5);

        graph.addEdge("t", "x", 1);
        graph.addEdge("t", "y", 2);

        graph.addEdge("x", "z", 4);

        graph.addEdge("y", "t", 3);
        graph.addEdge("y", "x", 9);
        graph.addEdge("y", "z", 2);

        graph.addEdge("z", "s", 7);
        graph.addEdge("z", "x", 6);
        return graph;
    }
}
