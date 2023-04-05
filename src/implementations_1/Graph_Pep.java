package implementations_1;

import java.util.ArrayList;

public class Graph_Pep {

    // this class contains the details of edges of graphs.
    static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    ArrayList<Edge>[] graph;
    public Graph_Pep(int vertex,int edges){
       graph = new ArrayList[vertex];
       for (int i = 0 ; i < vertex ; i++){
           graph[i] = new ArrayList<>();
       }
   }


    public void addEdge(int src, int nbr, int wt){
        Edge edge1 = new Edge(src, nbr, wt);
        Edge edge2 = new Edge(nbr, src, wt);
        graph[src].add(edge1);
        graph[nbr].add(edge2);
   }




    private void Display_(int size){
        for (int i = 0 ; i < size ; i++){
            System.out.println(i +" --> {"+graph[i].get(0).src+", "+graph[i].get(0).nbr+", "+graph[i].get(0).wt+"} ");

        }
   }

   public void display(){
        Display_(graph.length);
   }




}