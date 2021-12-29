import java.util.*;

class Solution {
    public static void main(String []args) {
        Graph graph = new Graph(false);
        graph.addVertex("1");
        System.out.println(graph);
        graph.addVertex("2");
        System.out.println(graph);
        graph.addEdge("1", "2", 3);
        System.out.println(graph.getWeight("1", "2"));
        System.out.println(graph);
    }
}

public class Graph {
    private final Map<String, Map<String, Integer>> adjVertices; // Adjacency Matrix implementation
    private final Map<String, Vertex> vertices;
    private Boolean directed;

    Graph(Boolean directed) {
        this.adjVertices = new HashMap<>();
        this.vertices = new HashMap<>();
        this.directed = directed;
    }

    public Integer getGraphVerticesQuantity() {
        return this.adjVertices.keySet().size();
    }

    public Boolean contains(String vertexKey) {
        return this.adjVertices.containsKey(vertexKey);
    }

    public Boolean addVertex(String vertexKey) {
        if (this.contains(vertexKey)) return false;
        this.adjVertices.put(vertexKey, new HashMap<>());
        this.vertices.put(vertexKey, new Vertex(vertexKey));
        return true;
    }

    public Boolean addEdge(String v1Key, String v2Key, Integer weight) {
        if (!this.contains(v1Key) || !this.contains(v2Key)) return false;
        this.adjVertices.get(v1Key).put(v2Key, weight);
        if (!this.directed) this.adjVertices.get(v2Key).put(v1Key, weight);
        return true;
    }

    public Set<String> getVertices() {
        return this.adjVertices.keySet();
    }

    public Integer getWeight(String v1Key, String v2Key) {
        if (!this.contains(v1Key) || !this.contains(v2Key)) return null;
        return this.adjVertices.get(v1Key).get(v2Key);
    }

    public Set<String> getNeighbors(String vertexKey) {
        if (!this.contains(vertexKey)) return null;
        return this.adjVertices.get(vertexKey).keySet();
    }

    public Vertex getNeighborAsVertex(String vertexKey) {
        if (!this.contains(vertexKey)) return null;
        return this.vertices.get(vertexKey);
    }

    public String toString() {
        return "Vertices: " + this.adjVertices.keySet() +
                "\nEdges: " + this.adjVertices.values() +
                "\nDirected: " + this.directed;
    }
}
