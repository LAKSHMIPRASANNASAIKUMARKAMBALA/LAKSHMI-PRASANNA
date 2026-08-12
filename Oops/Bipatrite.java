import java.util.*;
public class Bipatrite {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<V;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            l.get(u).add(v);
            l.get(v).add(u);
        }
        int color[]=new int[V];
        boolean found=true;
        Arrays.fill(color,-1);
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<V;i++){
        if(color[i]!=-1){
            continue;
        }
        color[i]=0;
        q.add(i);
        while(!q.isEmpty()){
            int node=q.remove();
            for(int n:l.get(node)){
                if(color[n]==-1){
                    color[n]=1-color[node];
                    q.add(n);
                }
                if(color[n]==color[node]){
found=false;
                }
            }
        }

       }
       if(found){
        System.out.print("Bipatrite");
       }
       else{
        System.out.print("Not Bipatrite");
       }
    }
}
