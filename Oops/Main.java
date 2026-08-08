import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        char c=sc.next().charAt(0);
        for(char ch:s.toCharArray()){
            if(ch==c){
                System.out.print("true");
                return;
            }

        }
        System.out.print("false");
    }
    
}