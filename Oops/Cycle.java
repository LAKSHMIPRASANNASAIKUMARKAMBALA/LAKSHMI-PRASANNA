import java.util.*;
class Cycle{
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
        boolean visited[]=new boolean[V+1];
        int src=sc.nextInt();
        visited[src]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,-1});
        while(!q.isEmpty()){
            int cell[]=q.remove();
            int curr=cell[0];
            int prev=cell[1];
            for(int n:l.get(curr)){
                if(!visited[n]){
                    visited[n]=true;
                    q.add(new int[]{n,curr});
                }
                else if(prev!=n){
                  System.out.print("Cycle");
                  return;
                }
            }   
        }
        System.out.print("Not Cycle");

    }
}