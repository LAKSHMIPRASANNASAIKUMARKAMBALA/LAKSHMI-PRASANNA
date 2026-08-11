import java.util.*;
class Matrix {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        int visi[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();            
                    }
            }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    q.add(new int[]{i,j,0});
                    visi[i][j]=1;
                }
                else{
                    visi[i][j]=0;
                }
            }
        }
        int dist[][]=new int[n][m];
        while(!q.isEmpty()){
            int cell[]=q.remove();
            int i=cell[0];
            int j=cell[1];
            int d=cell[2];
            dist[i][j]=d;
            int dr[]={-1,1,0,0};
            int dc[]={0,0,-1,1};
            for(int k=0;k<4;k++){
                int ro=dr[k]+i;
                int co=dc[k]+j;
                if(ro>=0 && ro<n && co>=0 && co<m && visi[ro][co]!=1){
                    visi[ro][co]=1;
                    q.add(new int[]{ro,co,d+1});
                }
            }
        }
        for(int i=0;i<n;i++)
        System.out.print(Arrays.toString(dist[i]));

        
    }
}

