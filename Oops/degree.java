import java.util.*;

class degree {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            l.get(u).add(v);
            l.get(v).add(u);
        }
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int c = 0;
            for (int a : l.get(i)) {
                c++;

            }
            arr[i] = c;
        }
        System.out.print(Arrays.toString(arr));
    }
}