import java.util.*;

public class Topological {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> l = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            l.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            l.get(a).add(b);
        }

        int visited[] = new int[V];
        int path[] = new int[V];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {

                if(dfs(i, l, visited, path, st)) {
                    System.out.print(new int[0]);
                    return;
                }
            }
        }

        while(!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static boolean dfs(int n, List<List<Integer>> l,
                              int visited[], int path[],
                              Stack<Integer> st) {

        path[n] = 1;
        visited[n] = 1;

        for(int a : l.get(n)) {

            if(visited[a] != 1) {

                if(dfs(a, l, visited, path, st)) {
                    return true;
                }

            } else if(path[a] == 1) {
                return true;
            }
        }

        path[n] = 0;
        st.push(n);

        return false;
    }
}