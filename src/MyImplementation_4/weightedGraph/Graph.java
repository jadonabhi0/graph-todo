package MyImplementation_4.weightedGraph;/*
    @author jadon
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Graph {

    // ths is 0-indexed weighted graph
    ArrayList<int[]>[] map;

    public Graph(int n){
        map = new ArrayList[n];
        for(int i = 0; i < n ; i++){
            map[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int ver, int wt){
        map[src].add(new int[]{ver, wt});
        map[ver].add(new int[]{src, wt});
    }

    public void Dijkstra(int src){
        // Time Complexity is E-log(V)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dis = new int[map.length];
        Arrays.fill(dis, Integer.MAX_VALUE);

        // new int[]{dis, node}
        pq.add(new int[]{0, src});
        dis[src] = 0;

        while(!pq.isEmpty()){
            int[] ar = pq.poll();
            int rmNode = ar[1];
            int rmDis = ar[0];

            for(int[] nbr : map[rmNode]){
                if(nbr[1]+rmDis < dis[nbr[0]]){
                    dis[nbr[0]] = nbr[1]+rmDis;
                    pq.add(new int[]{nbr[1]+rmDis, nbr[0]});
                }
            }
        }

        for(int i = 0 ; i < dis.length ; i++){
            System.out.println(i+" -> "+dis[i]);
        }

    }


    public void BellManFord(int src){
        int[] dis = new int[map.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        for(int rel = 0 ; rel < map.length ; rel++){
            for(int i = 0 ; i < map.length ; i++){
                for(int[] ar : map[i]){
                    int u = i;
                    int v = ar[0];
                    int wt = ar[1];
                    if(dis[u] != Integer.MAX_VALUE && dis[u]+wt < dis[v]){
                        dis[v] = dis[u]+wt;
                    }
                }
            }
        }

        //-------- This block of code checks the cycle in graph -----.
        for(int i = 0 ; i < map.length ; i++){
            for(int[] ar : map[i]){
                int u = i;
                int v = ar[0];
                int wt = ar[1];
                if(dis[u] != Integer.MAX_VALUE && dis[u]+wt < dis[v]){
                    System.out.println("This graph contains negative weight edge cycle");
                    break;
                }
            }
        }

        //---------------------------------------------------------


        // printing the distances
        System.out.println("using the bellman ford algo");
        for(int i = 0 ; i < map.length ; i++){
            System.out.println(i+" -> "+dis[i]);
        }

    }


}
