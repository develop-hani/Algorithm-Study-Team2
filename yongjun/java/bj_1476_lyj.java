import java.util.Scanner;

public class bj_1476_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt() - 1;
        int S = sc.nextInt() - 1;
        int M = sc.nextInt() - 1;

        int e = -1;
        int s = -1;
        int m = -1;
        int year = 0;
        while (true) {
            e = (e + 1) % 15;
            s = (s + 1) % 28;
            m = (m + 1) % 19;
            year++;
            if (e == E && s == S && M == m) {
                System.out.println(year);
                break;
            }
        }
    }
}
