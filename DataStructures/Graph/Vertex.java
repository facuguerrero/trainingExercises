public class Vertex  implements Comparable<Vertex>{
    private String key;
    private Double distance;
    private Boolean visited;

    Vertex(String key) {
        this.key = key;
        this.distance = Double.POSITIVE_INFINITY;
        this.visited = false;
    }

    Vertex(String key, Double distance, Boolean visited) {
        this.key = key;
        this.distance = distance;
        this.visited = visited;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(final Double distance) {
        this.distance = distance;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(final Boolean visited) {
        this.visited = visited;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return this.getDistance().compareTo(otherVertex.getDistance());
    }

    public String toString() {
        return "Key: " + this.key +
                "\nDistance: " + this.distance +
                "\nVisited: " + this.visited;
    }
}
