import java.util.*;

class Cycle {
    static boolean checkForCycle(int src, int V, List<List<Integer>> l, boolean[] vis) {
        vis[src] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int curr = cell[0];
            int prev = cell[1];

            for (int n : l.get(curr)) {
                if (!vis[n]) {
                    vis[n] = true;
                    q.add(new int[]{n, curr});
                } else if (prev != n) {
                    return true;
                }
            }
        }
        return false;
    }
//multiple components checking
    static boolean isCycle(int V, List<List<Integer>> l) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (checkForCycle(i, V, l, vis))
                    return true;
            }
        }
        return false;
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

        System.out.println(isCycle(V, l));
    }
}