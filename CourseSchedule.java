package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    class Solution {
        boolean[] visited;
        boolean[] path;
        boolean isCycle;
        List<Integer>[] graph;

        private void buildGraph(int numCourses, int[][] prerequisites) {
            graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] pre : prerequisites) {
                int course = pre[0];
                int prereq = pre[1];
                graph[prereq].add(course);
            }
        }

        private void DFS(int course) {
            if (path[course]) {
                isCycle = true;
                return;
            }
            if (visited[course] || isCycle) return;

            path[course] = true;
            for (int neighbor : graph[course]) {
                DFS(neighbor);
                if (isCycle) return;
            }
            path[course] = false;
            visited[course] = true;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) return true;

            visited = new boolean[numCourses];
            path = new boolean[numCourses];
            isCycle = false;

            buildGraph(numCourses, prerequisites);

            for (int i = 0; i < numCourses; i++) {
                if (!visited[i]) {
                    DFS(i);
                    if (isCycle) return false;
                }
            }
            return true;
        }
    }
}
