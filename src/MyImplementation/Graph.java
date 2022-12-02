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
         *
         * @return number of edges in graph.
         */
        public int noOfEdge(){
            int ans = 0;
            for(int key : map.keySet()){
                ans += map.get(key).size();
            }
            return ans/2;
        }

        /**
         *
         * @param v1 vertex
         * @param v2 vertex
         * @return v1 and v2 has an existing edge or not.
         */
        public boolean containsEdge(int v1, int v2){
            return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
        }

        /**
         * remove an Edge if exist
         * @param v1 vertex
         * @param v2 vertex
         */
        public void removeEdge(int v1, int v2){
            if (containsEdge(v1, v2)){
                map.get(v1).remove(v2);
                map.get(v2).remove(v1);
            }
        }

        /**
         * Remove the vertex
         * @param v is the given vertex.
         */
        public void removeVertex(int v){
            for(int key : map.get(v).keySet()){
                map.get(key).remove(v);
            }
            map.remove(v);
        }

        /**
         * Method that is useful for printing the graph.
         */
        public void display() {
            for (int key : map.keySet()) {
                System.out.println(key + " --> " + map.get(key));
            }
        }

        /**
         * Breadth first search
         * @author Abhishek Jadon
         * @param src is source to start the searching
         * @param dest is the node to be searched
         * @return the presence of destination
         */
        public boolean BFS(int src, int dest){
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();

            q.offer(src); // adding the source element

            while (!q.isEmpty()){
                // removing
                int rm = q.poll();

                if (visited.contains(rm)) continue;

                // mark visited
                visited.add(rm);

                // rm == dest
                if (rm == dest) return true;


                // adding nbrs
                for (int key : map.get(rm).keySet()){
                    if (visited.contains(key) == false) q.offer(key);
                }
            }

            return false;
        }

        /**
         * Depth first search
         * @param src is source to start the searching
         * @param dest is the node to be searched
         * @return the presence of destination
         */
        public boolean DFS(int src, int dest){
            Stack<Integer> st = new Stack<>();
            HashSet<Integer> visited = new HashSet<>();

            // adding the source to stack
            st.add(src);

            while(!st.isEmpty()){

                // remove
                int rm = st.pop();

                if (visited.contains(rm)) continue;

                // mark visited
                visited.add(rm);


                // rm == dest
                if(rm == dest) return true;

                // adding nbrs
                for(int key : map.get(rm).keySet()){
                    if (!visited.contains(key)) st.add(key);
                }
            }

            return false;
        }


        /**
         * Breadth first traversal
         */
        public void BFT(){
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for(int src : map.keySet()){
                if (visited.contains(src)) continue;

                // adding source to queue
                q.add(src);

                while (!q.isEmpty()){

                    // remove
                    int rm = q.poll();

                    // checking src is visited or not, if visited then skip.
                    if (visited.contains(rm)) continue;

                    // mark visited
                    visited.add(rm);

                    // printing
                    System.out.print(rm+" ");

                    // adding nbrs
                    for (int key : map.get(rm).keySet()){
                        if (visited.contains(key) == false)q.add(key);
                    }
                }
            }
            System.out.println();
        }


        /**
         * Depth first Traversal
         */
        public void DFT(){
            Stack<Integer> st = new Stack<>();
            HashSet<Integer> visited = new HashSet<>();
            for (int src : map.keySet()){
                if (visited.contains(src)) continue;

                // adding source to stack
                st.push(src);

                while(!st.isEmpty()){
                    // removing
                    int rm = st.pop();

                    // checking src is visited or not, if visited then skip
                    if (visited.contains(rm)) continue;

                    // mark visited
                    visited.add(rm);

                    // printing
                    System.out.print(rm+" ");

                    // adding nbrs
                    for (int key : map.get(rm).keySet()){
                        if (visited.contains(key) == false) st.push(key);
                    }
                }
            }
        }


        /**
         * @param src is source node
         * @param dest is destination node
         * @param visited set keep track the status of node has visited.
         * @return path exist or not between source to destination.
         */
        public  boolean hasPath(int src, int dest, HashSet<Integer> visited){
            if (src == dest) return true;

            // mark visited
            visited.add(src);

            // checking nbrs if not visited
            for(int key : map.get(src).keySet()){
                if (!visited.contains(key)){
                    boolean isPath = hasPath(key, dest, visited);
                    if(isPath) return true;
                }

            }
            return false;
        }


        /**
         * @param src is source node
         * @param dest is destination node
         * @param visited set keep track the status of node has visited.
         * @return path in all possible way from source to destination.
         */
        public void printAllPath(int src, int dest, String pathSoFar, HashSet<Integer> visited){
            if(src == dest){
                // printing the path if exist
                System.out.println(pathSoFar+src);
                return;
            }

            // mark visited
            visited.add(src);

            // adding nbrs if not visited.
            for(int key : map.get(src).keySet()){
                if (!visited.contains(key)){
                    // recursive call
                    printAllPath(key, dest, pathSoFar+src+" ", visited);
                }
            }

            // mark unvisited
            visited.remove(src);
        }


        /**
         * A connected graph is a graph where a path of distinct edges exists for each pair of vertices that connects them.
         * @return is graph connected or not.
         */
        public boolean graphIsConnected(){
            Stack<Integer> st = new Stack<>();
            HashSet<Integer> visited = new HashSet<>();
            int count = 0;

            for(int src : map.keySet()){

                if (visited.contains(src)) continue;
                count++;
                st.push(src);

                while(!st.isEmpty()){
                    int rm = st.pop();

                    if(visited.contains(rm)) continue;

                    visited.add(rm);

                    for (int key : map.get(rm).keySet()){
                        if (!visited.contains(key)) st.push(key);
                    }
                }
            }
            return count == 1;
        }


        /**
         *
         * @return an ArrayList of connected components
         */
        public ArrayList<ArrayList<Integer>> getAllConnectedComponent(){

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            HashSet<Integer> visited = new HashSet<>();
            Stack<Integer> st = new Stack<>();

            for (int src : map.keySet()){
                if (visited.contains(src)) continue;

                // adding source node to stack
                st.push(src);

                // arraylist that stores element of connected component.
                ArrayList<Integer> list = new ArrayList<>();
                while (!st.isEmpty()){
                    // removing
                    int rm = st.pop();

                    // checking visited
                    if (visited.contains(rm)) continue;

                    // mark visited
                    visited.add(rm);

                    // adding to list of connected components;
                    list.add(rm);

                    // adding nbrs
                    for(int key : map.get(rm).keySet()){
                        if (!visited.contains(key)) st.push(key);
                    }
                }
                ans.add(list);
            }
            return ans;
        }







    }/*END OF CLASS*/
