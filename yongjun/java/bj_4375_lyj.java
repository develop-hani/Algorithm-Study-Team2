import java.math.BigInteger;
import java.util.Scanner;

public class bj_4375_lyj {
    public static int findLength(String input){
        BigInteger n = new BigInteger(input);
        BigInteger value = BigInteger.ZERO;

        while (true) {
            value = value.multiply(BigInteger.TEN).add(BigInteger.ONE);
            if (value.mod(n).equals(BigInteger.ZERO)) {
                return value.toString().length();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int answer = findLength(sc.next());
            System.out.println(answer);
        }
    }
}