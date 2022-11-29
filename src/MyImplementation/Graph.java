package MyImplementation;/*
    @author Abhishek Jadon
*/

import java.util.*;

// This whole implementation is based on 1-based indexing.


    public class Graph {

        //hashmap is used to store the edges and vertex inorder to get better complexity.
       private HashMap<Integer, HashMap<Integer, Integer>> map;

        /**
         * Constructor of graph class.
         * @param v is number of vertex.
         */
        public Graph(int v){
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


        /**
         * Method that is useful for printing the graph.
         */
        public void display() {
            for (int key : map.keySet()) {
                System.out.println(key + " --> " + map.get(key));
            }
        }


        public boolean BFS(int src, int dest){
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();

            q.offer(src); // adding the source element

            while (!q.isEmpty()){
                // removing
                int rm = q.poll();

                // mark visited
                visited.add(rm);

                if (visited.contains(rm)) continue;

                // rm == dest
                if (rm == dest) return true;


                // adding nbrs
                for (int key : map.get(rm).keySet()){
                    if (!visited.contains(key)) q.offer(key);
                }
            }

            return false;
        }




    }
