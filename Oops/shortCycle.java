import java.util.*;

class shortCycle {
    static int checkForCycle(int src, int V, List<List<Integer>> l, boolean[] vis) {
        vis[src] = true;
        Queue<int[]> q = new LinkedList<>();
        int dist[] = new int[vis.length];
        dist[src] = 0;
        q.add(new int[]{src, -1});

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int curr = cell[0];
            int prev = cell[1];

            for (int n : l.get(curr)) {
                if (!vis[n]) {
                    vis[n] = true;
                    dist[n] = dist[curr] + 1;
                    q.add(new int[]{n, curr});
                } else if (prev != n) {
                    ans = Math.min(ans, dist[n] + dist[curr] + 1);
                }
            }
        }
        return ans;
    }

    static int isCycle(int V, List<List<Integer>> l) {
        boolean[] vis = new boolean[V];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                int x = checkForCycle(i, V, l, vis);
                ans = Math.min(ans, x);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < V; i++)
            l.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            l.get(u).add(v);
            l.get(v).add(u);
        }

        int ans = isCycle(V, l);

        if (ans == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(ans);
    }
}