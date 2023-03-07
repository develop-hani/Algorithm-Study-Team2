import java.util.*;

public class bj_1037_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(Collections.max(list) * Collections.min(list));
    }
}

