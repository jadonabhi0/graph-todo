package MyImplementation_4.DirectedGraph;/*
    @author jadon
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    List<Integer>[] map ;
    public Graph(int n){
        map = new List[n];
        for(int i = 0 ; i < n ; i++){
            map[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int ver){
        map[src].add(ver);

    }

    // print the graph
    public void printGraph(){
        for(int i = 0 ; i < map.length ; i++){
            System.out.println(i+" -> "+map[i]);
        }
    }

    // will detect the cycle
    public boolean isCyclicDFS(int node, int par, HashSet<Integer> set){
        set.add(node);
        for (int nbr : map[node]){
            if (!set.contains(nbr)){
                boolean hasCycle = isCyclicDFS(nbr, node, set);
                if (hasCycle) return true;
            }else{
                if(par != nbr) return true;
            }
        }
        set.remove(node);
        return false;
    }



    public boolean isCyclicBFS(int node, Queue<Integer> q, HashSet<Integer> vis){
        q.add(node);
        while(!q.isEmpty()){
            int rm = q.poll();
            vis.add(rm);
            for(int nbr : map[rm]){
                if(vis.contains(nbr)) return true;
                q.add(nbr);
            }
        }
        return false;
    }


}
