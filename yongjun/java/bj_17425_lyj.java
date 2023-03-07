import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_17425_lyj {
    static final int MAX = 1000000;
    static long[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        answer = new long[MAX + 1];
        search();

        for (int i = 1; i <= MAX; i++) {
            answer[i] += answer[i - 1];
        }

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(answer[N]).append("\n");
        }
        System.out.println(sb);

    }

    static void search() {
        for (int i = 1; i < MAX + 1; i++) {
            int j = 1;
            while (j * i <= MAX) {
                answer[j * i] += i;
                j++;
            }
        }
    }
}
