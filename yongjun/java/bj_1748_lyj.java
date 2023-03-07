import java.util.Scanner;

public class bj_1748_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int length = String.valueOf(N).length();

        int count = 9;
        int answer = 0;
        for (int i = 1; i < length; i++) {
            answer += count * i;
            count *= 10;
        }

        answer += (N - (int) Math.pow(10, length - 1) + 1) * length;
        System.out.println(answer);
    }
}
