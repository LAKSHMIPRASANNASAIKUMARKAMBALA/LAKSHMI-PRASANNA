import java.util.*;
public class BFSs {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=V;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            l.get(u).add(v);
            l.get(v).add(u);
        }
        int src=sc.nextInt();
        boolean visited[]=new boolean[V+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int n:l.get(curr)){
                if(!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
    }
}
