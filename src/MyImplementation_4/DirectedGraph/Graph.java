package MyImplementation_4.DirectedGraph;/*
    @author jadon
*/

import java.util.*;

public class Graph {

    List<Integer>[] map;

    public Graph(int n) {
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<>();
        }
    }


    public void addEdge(int src, int ver) {
        map[src].add(ver);

    }

    // print the graph
    public void printGraph() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(i + " -> " + map[i]);
        }
    }

    // will detect the cycle
    public boolean isCyclicDFS(int node, int par, HashSet<Integer> set) {
        set.add(node);
        for (int nbr : map[node]) {
            if (!set.contains(nbr)) {
                boolean hasCycle = isCyclicDFS(nbr, node, set);
                if (hasCycle) return true;
            } else {
                if (par != nbr) return true;
            }
        }
        set.remove(node);
        return false;
    }


    @Deprecated
    public boolean isCyclicBFS(int node, Queue<Integer> q, HashSet<Integer> vis) {
        q.add(node);
        while (!q.isEmpty()) {
            int rm = q.poll();
            if (vis.contains(rm)) return true;
            vis.add(rm);
            for (int nbr : map[rm]) {
                if (!vis.contains(nbr)) q.add(nbr);
            }
        }
        return false;
    }


    // Topological Sorting : It is a permutation of vertices for a Directed Acyclic Graph such that vertex (u, v)
    // u always occurs before v in graph;

    public void topologicalSort(List<Integer>[] map) {
        int[] vis = new int[map.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) dfsTop(map, vis, st, i);
        }
        System.out.println(st);
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public void dfsTop(List<Integer>[] map, int[] vis, Stack<Integer> st, int node) {
        vis[node] = 1;
        for (int nbr : map[node]) {
            if (vis[nbr] == 0) dfsTop(map, vis, st, nbr);
        }
        st.push(node);
    }

    //Topological order using Kahn’s topological sort
    public void khansAlgo() {
        if (isCyclicTopoSort()) return;
        int[] indegree = new int[map.length];
        // calculating indegree
        for (int i = 0; i < map.length; i++) {
            for (int nbr : map[i]) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i : indegree) {
            if (i == 0) q.add(i);
        }

        // bfs
        while (!q.isEmpty()) {
            int rm = q.poll();
            System.out.print(rm + " ");
            for (int nbr : map[rm]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) q.add(nbr);
            }
        }
    }

    public boolean isCyclicTopoSort() {
        int[] indegree = new int[map.length];
        // calculating indegree
        for (int i = 0; i < map.length; i++) {
            for (int nbr : map[i]) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i : indegree) {
            if (i == 0) q.add(i);
        }

        // bfs
        int count = 0;
        while (!q.isEmpty()) {
            int rm = q.poll();
            count++;
            for (int nbr : map[rm]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) q.add(nbr);
            }
        }

        if (count == map.length) return false;
        return true;
    }


}
