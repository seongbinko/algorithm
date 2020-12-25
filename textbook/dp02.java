package textbook;
import java.util.Scanner;

public class dp02 {

    public static int[] f = new int[101];
    public static int n;

    public static int dynamic(int[] k) {
        for(int i=3; i<n+1; i++) {
            if(k[i] + k[i/2] >= k[i-1]) {
                f[i] = k[i] + k[i /2];
            } else {
                f[i] = k[i-1];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] k = new int[n+1];
        for(int i=1; i < k.length; i++) {
            k[i] = sc.nextInt();
        }
        System.out.println(dynamic(k));
    }
}