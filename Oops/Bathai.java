import java.util.*;
public class Bathai {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j=0;j<m;j++){
            arr[i][j]=sc.nextInt();
    
            
        }}
        // 2-rotten oranges
        //1 -frsh oranges
        //0- No oranges
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(arr[i][j]==1){
                    fresh++;
                }
            }
        }
        int min=0;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int cell[]=q.remove();
                for(int k=0;k<4;k++){
                    int row=cell[0]+dr[k];
                    int col=cell[1]+dc[k];
                    if(row>=0 && row<n && col>=0 && col<m && arr[row][col]==1){
                        fresh--;
                        arr[row][col]=2;
                        q.add(new int[]{row,col});
                    }
                }
            }
             min++;
        }
        if(fresh==0)
        System.out.print(min+" ");
else{
    System.out.print(-1);
}

    }
    
}
