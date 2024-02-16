import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    //hashmap is used to store the edges and vertex inorder to get better complexity.
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    /**
     * Constructor of graph class.
     * @param v is number of vertex.
     */
    public PrimsAlgorithm(int v){
        map = new HashMap<>();
        for(int i = 1 ; i <= v ; i++){
            map.put(i, new HashMap<>());
        }
    }

    /**
     * Add an edge between two vertex of graph.
     * @param v1 represent the vertex.
     * @param v2 represent the vertex.
     * @param cost is weight of that edge.
     */
    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    private class PrimsPair {
        int src;
        int ref;
        int cost;

        PrimsPair(int src, int ref, int cost) {
            this.src = src;
            this.ref = ref;
            this.cost = cost;
        }
    }

    public void PrimsAlgo(){



        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair o1, PrimsPair o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new PrimsPair(1,-1, 0));

        while(!pq.isEmpty()){
            PrimsPair rm = pq.poll();
            if (visited.contains(rm.src)) continue;
            visited.add(rm.src);
            if (rm.ref != -1) {
                System.out.println("["+rm.ref+"->"+rm.src+" @ "+rm.cost+"]");
            }
            for(int key : map.get(rm.src).keySet()){
                if (!visited.contains(key)){
                    pq.add(new PrimsPair(key, rm.src, map.get(rm.src).get(key)));
                }
            }
        }
    }
}
