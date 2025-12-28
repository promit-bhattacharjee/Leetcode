package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import Graph.Dijkstra.Pair;

public class MinCostToConnectAllPoints {
    class Solution {
        public class Edge {
            int index;
            int cost;

            Edge(int index, int cost) {
                this.index = index;
                // this.dest = dest;
                this.cost = cost;
            }
        }

        public class Pair implements Comparable<Pair> {
            int node;
            int cost;
            // int dest;

            Pair(int node, Integer cost) {
                this.node = node;
                this.cost = cost;
            }

            // Pair(int index, int dest, Integer cost) {
            // this.index = index;
            // this.dest = dest;
            // this.cost = cost;
            // }

            @Override
            public int compareTo(Pair p) {
                return this.cost - p.cost;
            }

        }

        public int calculateDistance(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

        public int minCostConnectPoints(int[][] points) {
            int v = points.length, count = -1;
            ArrayList<Edge> edges[] = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                edges[i] = new ArrayList<Edge>();
            }
            for (int i = 0; i < v; i++) {
                for (int j = i + 1; j < v; j++) {
                    int dis = calculateDistance(points[i][0], points[i][1],
                            points[j][0], points[j][1]);
                    edges[i].add(new Edge(j, dis));
                    edges[j].add(new Edge(i, dis));
                }
            }
            for (int i = 0; i < v; i++) {
                for (Edge e : edges[i]) {
                    System.out.println("src : " + i + " " + "dest : " + e.index + " " + "w : " + e.cost);
                }
                System.out.println();
            }
            PriorityQueue<Pair> nonMst = new PriorityQueue<>();
            int mstCount=0;
            nonMst.add(new Pair(0, 0));
            boolean vis[] = new boolean[v];
            while (!nonMst.isEmpty()) {
                Pair p = nonMst.remove();
                if (!vis[p.node]) {
                    vis[p.node] = true;
                    mstCount+=p.cost;
                    System.out.println(mstCount);
                    for (Edge e : edges[p.node]) {
                        if (!vis[e.index]) {
                            nonMst.add(new Pair(e.index, e.cost));
                        }
                    }
                }
            }
            return mstCount;
        }

    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints outer = new MinCostToConnectAllPoints();
        MinCostToConnectAllPoints.Solution sn = outer.new Solution();
        int[][] points = {
                { 0, 0 },
                { 2, 2 },
                { 3, 10 },
                { 5, 2 },
                { 7, 0 }
        };
        int res = sn.minCostConnectPoints(points);
        System.out.println(res);
    }
}