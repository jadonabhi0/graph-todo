package MyImplementation_4.DirectedGraph;/*
    @author jadon
*/

import java.util.HashSet;
import java.util.LinkedList;

public class client {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(3,0);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(6,5);
        graph.printGraph();
        System.out.println(graph.isCyclicDFS(0, -1, new HashSet<>()));
//        System.out.println(graph.isCyclicBFS(0, new LinkedList<>(), new HashSet<>()));
        graph.topologicalSort(graph.map);
        System.out.println();
        graph.khansAlgo();
        System.out.println();
        System.out.println(graph.isCyclicTopoSort());
    }
}
