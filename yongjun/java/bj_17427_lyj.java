import java.util.Scanner;

public class bj_17427_lyj {
    public static void main(String[] args) {
        // N보다 작거나 같은 모든 자연수의 약수의 합
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += (long) (N / i) * i;
        }
        System.out.println(answer);
    }
}

