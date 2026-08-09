import java.util.*;
class Bfs{
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
        System.out.print(l);
        }

    }

