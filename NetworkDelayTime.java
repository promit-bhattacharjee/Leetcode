package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
    class Solution {
        public class Pair implements Comparable<Pair> {
            int node, w;

            Pair() {
            }

            Pair(int node, int w) {
                this.node = node;
                this.w = w;
            }

            @Override
            public int compareTo(Pair p) {
                return this.w - p.w;
            }

        }

        public ArrayList<Pair>[] createGraph(int[][] graph, int n) {
            ArrayList<Pair> nodes[] = new ArrayList[n + 1];
            int i = 1;
            for (; i < n + 1;) {
                nodes[i++] = new ArrayList<>();
            }
            for (int[] e : graph) {

                nodes[e[0]].add(new Pair(e[1], e[2]));
            }
            return nodes;
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            Queue<Pair> pq = new PriorityQueue<>();
             ArrayList<Pair> nodes[] = createGraph(times, n);
            int dest[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dest[i] = Integer.MAX_VALUE;
            }
            int count = -1;
            pq.add(new Pair(k, 0));
            dest[k] = 0;
            while (!pq.isEmpty()) {
                Pair p = pq.remove();
                int d=p.w;
                int u = p.node;
                if (dest[u]>d) {
                    continue;
                }
                for(Pair nei: nodes[u]){
                   int v=nei.node;
                   int w= nei.w;
                   if (dest[u]+w<dest[v]) {
                        dest[v]=dest[u]+w;
                        pq.add(new Pair(v,dest[v]));
                   }
                }
            }
            for(int i=1;i<=n;i++){
                if (dest[i]==Integer.MAX_VALUE) {
                    return -1;
                }
                count = Integer.max(count, dest[i]);
            }
            return count;

        }
    }

    public static void main(String[] args) {
        NetworkDelayTime outer = new NetworkDelayTime();
        NetworkDelayTime.Solution sn = outer.new Solution();
        int[][] r = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        sn.networkDelayTime(r, 4, 2);
    }

}
