package MyImplementation;/*
    @author jadon
*/

public class Client_Graph {
    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(2,4,1);
        graph.addEdge(3,4,1);
        graph.addEdge(2,5,1);
        graph.addEdge(4,5,1);

        graph.display();
    }

}
