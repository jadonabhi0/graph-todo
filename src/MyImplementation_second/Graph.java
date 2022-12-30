package MyImplementation_second;/*
    @author jadon
*/

import java.util.*;

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

    public int noOfEdges(){
        int s = 0;
        for(int i = 1 ; i <= map.size() ; i++){
            s += map.get(i).size();
        }
        return s/2;
    }

    public void display(){
        for(int i = 1 ; i <= map.size() ; i++){
            System.out.println(i+" -> "+map.get(i));
        }
    }

    public boolean containsEdge(int v1, int v2){
        return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
    }

    public void removeEdge(int v1, int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }


    public void removeVertex(int v){
        for(int i : map.get(v).keySet()){
            map.get(i).remove(v);
        }
        map.remove(v);
    }

    public boolean BFS(int src, int dest){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.offer(src);
        visited.add(src);

        while(!q.isEmpty()){
            int rm = q.poll();
            if(rm == dest) return true;
            for(int i : map.get(rm).keySet()){
                if (!visited.contains(i)){
                    q.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }


    public boolean DFS(int src, int dest){
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        st.push(src);
        visited.add(src);

        while(!st.isEmpty()){
            int rm = st.pop();
            if(rm == dest) return true;
            for(int i : map.get(rm).keySet()){
                if (!visited.contains(i)){
                    st.push(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }


    public boolean hasPath(int src, int dest, HashSet<Integer> visited){
        if (src == dest) return true;
        visited.add(src);
        for(int key : map.get(src).keySet()){
            if(!visited.contains(key)){
                boolean ispath = hasPath(key, dest, visited);
                if (ispath) return true;
            }
        }
        return false;
    }
    

} // end of class
