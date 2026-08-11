import java.util.*;
public class XO {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char board[][]=new char[n][m];
        int visi[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=sc.next().charAt(0);
            }
        }
       for(int i=0;i<n;i++){
        int j=0;
        if(board[i][j]=='O'){
            dfs(i,j,board,visi);
        }
       }
       for(int i=0;i<n;i++){
        int j=m-1;
        if(board[i][j]=='O'){
            dfs(i,j,board,visi);
        }
       }
       for(int i=0;i<m;i++){
        int j=0;
        if(board[j][i]=='O'){
            dfs(j,i,board,visi);
        }
       }
       for(int i=0;i<m;i++){
        int j=n-1;
        if(board[j][i]=='O'){
            dfs(j,i,board,visi);
        }
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]=='O' && visi[i][j]!=1){
                board[i][j]='X';
            }
        }
       }
       for(int i=0;i<n;i++){
        System.out.print(Arrays.toString(board[i]));
       }
    }
    public static void dfs(int i,int j,char board[][],int visi[][]){
        visi[i][j]=1;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int k=0;k<4;k++){
            int ro=dr[k]+i;
            int co=dc[k]+j;
            if(ro>=0 && ro<board.length && co>=0 && co<board[0].length && visi[ro][co]!=1 && board[ro][co]=='O'){
                visi[ro][co]=1;
                dfs(ro,co,board,visi);
            }
        }
    }
}
