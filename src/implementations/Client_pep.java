package implementations;

public class Client_pep {
    public static void main(String[] args) {

        Graph_Pep graph = new Graph_Pep(7,8);
            graph.addEdge(0,1,10);
            graph.addEdge(1,2,10);
            graph.addEdge(2,3,10);
            graph.addEdge(0,3,10);
            graph.addEdge(3,4,10);
            graph.addEdge(4,5,10);
            graph.addEdge(5,6,10);
            graph.addEdge(4,6,10);

            graph.display();

    }
}
