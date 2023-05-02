package MyImplementation_3;/*
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

    public void printAllPath(int src, int dest, String psf, HashSet<Integer> visited){
        if(src == dest){
            psf = psf+" "+src;
            System.out.println(psf);
            return;
        }
        visited.add(src);

        for(int key : map.get(src).keySet()){
            if(!visited.contains(key)){
                printAllPath(key, dest, psf+" "+src, visited);
            }
        }

        visited.remove(src);
    }

    public boolean isConnected(){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for(int src : map.keySet()){
            if(visited.contains(src)) continue;
            q.offer(src);
            visited.add(src);
            count++;
            while (!q.isEmpty()){
                int rm = q.poll();
                for (int key : map.get(rm).keySet()){
                    if(!visited.contains(key)){
                        q.offer(key);
                        visited.add(key);
                    }
                }
            }
        }
        return count == 1;
    }

    public void getAllConnectedComponents(){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> list ;

        for(int src : map.keySet()){
            if(visited.contains(src)) continue;
            q.offer(src);
            visited.add(src);
            list = new ArrayList<>();
            while (!q.isEmpty()){
                int rm = q.poll();
                list.add(rm);
                for (int key : map.get(rm).keySet()){
                    if(!visited.contains(key)){
                        q.offer(key);
                        visited.add(key);
                    }
                }
            }
            System.out.println(list);
        }
    }


    public boolean isCyclic(){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for(int src : map.keySet()){
            if(visited.contains(src)) continue;
            q.offer(src);

            while (!q.isEmpty()){
                int rm = q.poll();
                if(visited.contains(rm)) return true;
                visited.add(rm);
                for(int key : map.get(rm).keySet()){
                    if(!visited.contains(key)){
                        q.offer(key);
                    }
                }
            }
        }


        


        return false;
    }






} // end of class
