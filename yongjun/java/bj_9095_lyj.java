import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_9095_lyj {
    static int[] set = {1, 2, 3};
    static int maxLength = 10;
    static int[] numbers = new int[maxLength];
    static int[] answer = new int[maxLength + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= maxLength; i++) {
            generate(0, i);
        }

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(answer[n]).append("\n");
        }
        System.out.println(sb);
    }

    static void generate(int depth, int length) {
        if (depth == length) {
            int sum = 0;
            for (int number : numbers) {
                if (number == 0)
                    break;
                sum += number;
            }
            if (sum <= 10) {
                answer[sum]++;
            }
            return;
        }

        for (int i = 0; i < set.length; i++) {
            numbers[depth] = set[i];
            generate(depth + 1, length);
        }
    }
}
