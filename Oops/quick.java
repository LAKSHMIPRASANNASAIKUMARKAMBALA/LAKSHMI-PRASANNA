import java.util.*;
class quick{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int l=0,h=n-1;
        qs(arr,l,h);
        System.out.print(Arrays.toString(arr));
    }
    public static void qs(int arr[],int l,int h){
        if(l<h){
            int pi=func(arr,l,h);
            qs(arr,l,pi-1);
            qs(arr,pi+1,h);
        }
    }
    public static int func(int arr[],int l,int h){
        int pivot=arr[l];
        int i=l;
        int j=h;
        while(i<j){
            while(i<h && arr[i]<=pivot){
                i++;
            }
            while(j>l && arr[j]>pivot){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,j,l);
        return j;

    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}