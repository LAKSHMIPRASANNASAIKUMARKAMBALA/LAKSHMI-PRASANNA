import java.util.*;
class Pair{
    int row;
    int col;
    public Pair(int i,int j){
       row=i;
       col=j;
    }
}
public class islands {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for (int i = 0; i< n; i++) {
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();

            }   
        }
        int visited[][]=new int[n][m];
        int comp=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && arr[i][j]==1){
                    comp++;
                    bfs(visited,arr,i,j);
                }
            }
        }
        System.out.print(comp);

    }
    public static void bfs(int visited[][],int arr[][],int i,int j){
        visited[i][j]=1;
        Queue<Pair> q=new LinkedList<Pair>();
q.add(new Pair(i,j));
while(!q.isEmpty()){
int first=q.peek().row;
int second=q.peek().col;
q.remove();
for(int row=-1;row<=1;row++){
    for(int col=-1;col<=1;col++){
        int delr=row+first;
        int delc=col+second;
        if(delr>=0 && delr<arr.length && delc>=0 && delc<arr[0].length && visited[delr][delc]!=1 && arr[delr][delc]==1){
            visited[delr][delc]=1;
            q.add(new Pair(delr,delc));

        }
    }
}

    }
}
}
