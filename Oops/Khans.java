import java.util.*;

public class Khans {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> l = new ArrayList<>();

        for(int i = 0; i < V; i++){
            l.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            l.get(a).add(b);
        }

        // Indegree
        int arr[] = new int[V];

        for(int i = 0; i < V; i++){
            for(int a : l.get(i)){
                arr[a]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int top[] = new int[V];
        int ind = 0;

        // Add all vertices having indegree 0
        for(int i = 0; i < V; i++){
            if(arr[i] == 0){
                q.add(i);
            }
        }

        // Kahn's Algorithm
        while(!q.isEmpty()){

            int curr = q.peek();
            q.remove();

            top[ind++] = curr;

            for(int a : l.get(curr)){

                arr[a]--;

                if(arr[a] == 0){
                    q.add(a);
                }
            }
        }

        System.out.println(Arrays.toString(top));
    }
}