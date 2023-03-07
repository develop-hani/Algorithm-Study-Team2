import java.util.Arrays;
import java.util.Scanner;

public class bj_1929_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        check(isPrime);
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void check(boolean[] isPrime) {
        for (int i = 2; i < (int) Math.sqrt(isPrime.length) + 1; i++) {
            int j = 2;
            while (j * i < isPrime.length) {
                isPrime[j * i] = false;
                j++;
            }
        }
    }
}
