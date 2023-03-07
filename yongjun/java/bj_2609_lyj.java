import java.util.Scanner;

public class bj_2609_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcd(a, b);
        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }

    static int gcd(int a, int b) {
        while (b != 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
