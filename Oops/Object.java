import java.util.*;
public class Object {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Jude j=new Jude();
        String s=sc.nextLine();
        int age=sc.nextInt();
        j.print(s,age);
        
    }
}
 class Jude{
    public void print(String s,int age){
        System.out.print("Name "+s);
        System.out.print("age"+age);
    }

}
