package MyImplementation_4.weightedGraph;/*
    @author jadon
*/

public class Client {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 6);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 5, 15);
        graph.addEdge(3, 4, 10);
        graph.addEdge(4, 5, 6);
        graph.addEdge(4, 6, 2);
        graph.addEdge(5, 6, 6);
        graph.Dijkstra(5);
        graph.BellManFord(5);
    }
}
