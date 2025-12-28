package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.namespace.QName;

import Graph.Dijkstra.Edge;
import partern.Recursion.Factorial;

public class MinimumCosttoReachDestinationinTime {
    class Solution {
        class Edge {
            int src, dest, w, passingFees;

            Edge(int src, int dest, int w, int passingFees) {
                this.src = src;
                this.dest = dest;
                this.w = w;
                this.passingFees = passingFees;
            }
        }

        public int minCost(int maxTime, int[][] edges, int[] passingFees) {
            int ver = passingFees.length;
            // ArrayList<Edge> nodes[] = new ArrayList[v];
            // for (int i = 0; i < v; i++) {
            // nodes[i] = new ArrayList<Edge>();
            // nodes[i].add(new Edge(edges[i][0], edges[i][1], edges[i][2],
            // passingFees[i]));
            // }
            Queue<Edge> q = new LinkedList<Edge>();
            for (int i = 0; i < ver; i++) {
                q.add(new Edge(edges[i][0], edges[i][1], edges[i][2], passingFees[i]));
            }
            boolean vis[] = new boolean[ver];
            Arrays.fill(passingFees, Integer.MAX_VALUE);
            Arrays.fill(vis, false);
            while (!q.isEmpty()) {
                Edge e = q.poll();
                if (!vis[e.dest]) {
                    int u = e.src;
                    int v = e.dest;
                    int w = e.w;
                    if (passingFees[u] + w < v && w <= maxTime && passingFees[v] != Integer.MAX_VALUE) {
                        vis[v] = true;
                        passingFees[v] = u + w;
                    }
                }

            }
            return passingFees[ver - 1];
        }

        public static void main(String[] args) {
            int maxTime = 30;
            int[][] edges = {
                    { 0, 1, 10 },
                    { 1, 2, 10 },
                    { 2, 5, 10 },
                    { 0, 3, 1 },
                    { 3, 4, 10 },
                    { 4, 5, 15 }
            };

            int passingFees[] = { 5, 1, 2, 20, 20, 3 };
            MinimumCosttoReachDestinationinTime outer = new MinimumCosttoReachDestinationinTime();
            MinimumCosttoReachDestinationinTime.Solution sn = outer.new Solution();
            int result = sn.minCost(maxTime, edges, passingFees);
            System.out.println(result);

        }
    }
}
