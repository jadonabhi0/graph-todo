import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

        //hashmap is used to store the edges and vertex inorder to get better complexity.
        private HashMap<Integer, HashMap<Integer, Integer>> map;

        /**
         * Constructor of graph class.
         * @param v is number of vertex.
         */
        public DijkstraAlgorithm(int v){
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


        
        // Dijkstra Pair class
        class DijPair{
            int vtx; // vertex
            String psf; // path so far
            int cost; // cost

            // sweet sa constructor
            DijPair(int vtx, String psf, int cost){
                this.vtx = vtx;
                this.psf = psf;
                this.cost = cost;
            }
        }

        /**
         * Dijkstra algorithm gives the shortest path in-terms of cost from one source node to all nodes.
         * @param src is the source vertex.
         */
        public void DijkstraAlgo(int src){
            // visited array
            HashSet<Integer> visited = new HashSet<>();

            // priority queue, polls based on cost;
            PriorityQueue<DijPair> pq = new PriorityQueue<>(new Comparator<DijPair>() {
                @Override
                public int compare(DijPair o1, DijPair o2) {
                    return o1.cost - o2.cost;
                }
            });
            DijPair pair = new DijPair(src, src+"", 0); // make src object
            // add src to priority Queue
            pq.add(pair);

            while (!pq.isEmpty()){
                // remove
                DijPair rm = pq.poll();
                // check
                if (visited.contains(rm.vtx)) continue;
                // mark visited
                visited.add(rm.vtx);
                // work
                System.out.println(rm.vtx +" | via "+ rm.psf + " cost "+ rm.cost);
                // add nbrs
                for(int key : map.get(rm.vtx).keySet()){
                    DijPair pair1 = new DijPair(key, rm.psf+"->"+key, rm.cost+map.get(rm.vtx).get(key));
                    if(!visited.contains(key)){
                        pq.add(pair1);
                    }
                }
            }

        }
}
