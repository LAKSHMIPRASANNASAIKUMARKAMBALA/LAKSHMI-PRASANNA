import java.util.*;

public class Dfs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            l.get(u).add(v);
            l.get(v).add(u);
        }
        int src = sc.nextInt();
        boolean visited[] = new boolean[V + 1];

        System.out.print(src + " ");
        visited[src] = true;
        for (int n : l.get(src)) {
            if (!visited[n]) {
                dfs(n, visited, l);
            }
        }

    }

    public static void dfs(int n, boolean visited[], List<List<Integer>> l) {
        System.out.print(n + " ");
        visited[n] = true;
        for (int a : l.get(n)) {
            if (!visited[a]) {
                dfs(a, visited, l);

            }
        }
    }
}
