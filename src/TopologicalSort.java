import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Graph{
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    int v;
    Graph(int v){
        this.v = v;
        for(int i = 0 ; i < v ; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
    }

    public void display(){
        for(int key : map.keySet()){
            System.out.println(key+"=>"+map.get(key));
        }
    }

    public void topologicalSort(){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int i : map.keySet()){
            if (!visited.contains(i)){
                topologicalSort_(i, visited, st);
            }
        }
        while (st.size()>0) System.out.println(st.pop());

    }

    public void topologicalSort_(int src, HashSet<Integer> visited, Stack<Integer> st){
        visited.add(src);
        for(int key : map.get(src).keySet()){
            if (!visited.contains(key)){
                topologicalSort_(key, visited, st);
            }
        }
        st.push(src);
    }


}
public class TopologicalSort {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0,3,0);
        graph.addEdge(0,1,0);
        graph.addEdge(1,2,0);
        graph.addEdge(2,3,0);
        graph.addEdge(4,3,0);
        graph.addEdge(4,5,0);
        graph.addEdge(4,6,0);
        graph.addEdge(5,6,0);
        graph.topologicalSort();
        graph.display();
    }
}
