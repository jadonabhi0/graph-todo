package MyImplementation_2;/*
    @author jadon
*/

public class Client_Graph {
    public static void main(String[] args) {

        Graph graph = new Graph(9);
        graph.addEdge(1, 4, 5);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 7);
        
        
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 12);
        graph.addEdge(5, 6, 3);
        graph.addEdge(5, 7, 2);
        graph.addEdge(6, 7, 7);
        graph.addEdge(8, 9, 3);
//
//        System.out.println(graph.BFS(1, 6));
//        System.out.println(graph.DFS(1,6));

//        graph.BFT();
//        graph.DFT();

//        System.out.println(graph.hasPath(7, 1, new HashSet<>()));

//        graph.printAllPath(1, 7, "", new HashSet<>());

//        System.out.println(graph.noOfEdge());

//        System.out.println(graph.containsEdge(1, 4));
//        graph.removeEdge(1,4);
//        System.out.println(graph.containsEdge(1, 4));

//        graph.printAllPath(1, 7, "", new HashSet<>());

//        System.out.println(graph.graphIsConnected());
//        graph.DijkstraAlgo(1);

        graph.PrimsAlgo();

    }

}
