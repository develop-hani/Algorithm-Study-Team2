import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_6588_lyj {
    static int N = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        findPrimeNumber(isPrime);

        int n = -1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            boolean isFind = false;
            for (int i = 3; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    isFind = true;
                    break;
                }
            }
            if (!isFind)
                sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb);
    }

    static void findPrimeNumber(boolean[] isPrime) {
        for (int i = 2; i < (int) Math.sqrt(N) + 1; i++) {
            int j = 2;
            while (j * i <= N) {
                isPrime[j * i] = false;
                j += 1;
            }
        }
    }
}
