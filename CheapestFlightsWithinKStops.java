package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
    class Solution {
        public class Edge {
            int node, w;

            Edge(int node, int w) {
                this.node = node;
                this.w = w;
            }
        }

        class Pair implements Comparable<Pair> {
            int node;
            int w;
            int calls;

            Pair(int node, int calls, int w) {
                this.calls = calls;
                this.node = node;
                this.w = w;
            }

            @Override
            public int compareTo(Pair p) {
                return this.w - p.w;
            }
        }

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            ArrayList<Edge>[] edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int[] f : flights) {
                edges[f[0]].add(new Edge(f[1], f[2]));
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(src, 0, 0));
            int dist[][] = new int[n][k + 2];
            for (int i[] : dist) {
                Arrays.fill(i, Integer.MAX_VALUE);
            }
            dist[src][0] = 0;
            while (!pq.isEmpty()) {
                Pair e = pq.remove();
                if (e.calls > k)
                    continue;
                for (Edge eg : edges[e.node]) {
                    int u = e.node;
                    int w = eg.w;
                    int v = eg.node;
                    if (dist[u][e.calls] + w < dist[v][e.calls + 1]) {
                        dist[v][e.calls + 1] = dist[u][e.calls] + w;
                        pq.add(new Pair(v, e.calls + 1, dist[v][e.calls + 1]));
                    }
                }

            }
            int cost = Integer.MAX_VALUE;
            for (int i : dist[dst]) {
                if (cost > i) {
                    cost = i;
                }
            }
            return cost == Integer.MAX_VALUE ? -1 : cost;

        }
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops outer = new CheapestFlightsWithinKStops();
        CheapestFlightsWithinKStops.Solution sn = outer.new Solution();
        int[][] graph = {
                { 0, 1, 5 },
                { 1, 2, 5 },
                { 0, 3, 2 },
                { 3, 1, 2 },
                { 1, 4, 1 },
                { 4, 2, 1 }
        };

        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;
        int result = sn.findCheapestPrice(n, graph, src, dst, k);
        System.out.println(result);
    }
}
