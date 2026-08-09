import java.util.*;
class Comp{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=V;i++){
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
           int u=sc.nextInt();
           int v=sc.nextInt();
           l.get(u).add(v);
           l.get(v).add(u);
            
        }
        boolean visited[]=new boolean[V+1];
        int comp=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                comp++;
                dfs(i,l,visited);
            }

        }
        System.out.print(comp);


    }
    public static void dfs(int node,List<List<Integer>> l,boolean visited[]){
visited[node]=true;
for(int n:l.get(node)){
    if(!visited[n])
    dfs(n,l,visited);
}
    }

}