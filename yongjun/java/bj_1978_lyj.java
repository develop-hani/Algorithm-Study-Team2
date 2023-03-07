import java.util.Scanner;

public class bj_1978_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isPrime(sc.nextInt()))
                count++;
        }
        System.out.println(count);
    }

    static boolean isPrime(int n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;

        for (int i = 2; i < (int)Math.sqrt(n) + 1; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
