package MyImplementation_second;/*
    @author jadon
*/

import java.util.HashMap;

public class Graph {

    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public Graph(int v){
        map = new HashMap<>();
        for(int i = 1 ; i <= v ; i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int src, int dest, int cost){
        map.get(src).put(dest, cost);
        map.get(dest).put(src,cost);
    }


}
