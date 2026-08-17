import java.util.*;

class Solution {

    static class Pair {
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static void dfs(int n, List<List<Pair>> l, int[] visited,
                           Stack<Integer> st) {

        visited[n] = 1;

        for (Pair a : l.get(n)) {
            if (visited[a.node] != 1) {
                dfs(a.node, l, visited, st);
            }
        }

        st.push(n);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        List<List<Pair>> l = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int node = edges[i][1];
            int wt = edges[i][2];

            l.get(u).add(new Pair(node, wt));
        }

        int[] visited = new int[N];

        Stack<Integer> st = new Stack<>();

        // Topological sort
        for (int i = 0; i < N; i++) {
            if (visited[i] != 1) {
                dfs(i, l, visited, st);
            }
        }

        int[] dist = new int[N];

        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;

        // Relax edges according to topological order
        while (!st.isEmpty()) {

            int curr = st.pop();

            if (dist[curr] != (int) 1e9) {

                for (Pair p : l.get(curr)) {

                    int v = p.node;
                    int wt = p.wt;

                    if (dist[curr] + wt < dist[v]) {
                        dist[v] = dist[curr] + wt;
                    }
                }
            }
        }

        // Convert unreachable nodes to -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}