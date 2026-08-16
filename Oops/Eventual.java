import java.util.*;
public class Eventual States {
   public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int V=sc.nextInt();
    int E=sc.nextInt();
    List<List<Integer>> l=new ArrayList<>();
   for(int i=0;i<V;i++){
    l.add(new ArrayList<>());
   }
   for(int i=0;i<E;i++){
    int a=sc.nextInt();
    int b=sc.nextInt();
    l.get(a).add(b);
   }
   int visited[]=new int[V];
   int path[]=new int[V];
   int check[]=new int[V];
for(int i=0;i<V;i++){
    if(visited[i]==0){
        dfs(i,l,visited,path,check);
    }
}
   } 
}
