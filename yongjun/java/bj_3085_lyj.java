import java.util.Scanner;

public class bj_3085_lyj {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        // 구현
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    char temp;
                    // 인접한 사탕 스왑(다를때만)
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (arr[nx][ny] != arr[x][y]) {
                            temp = arr[x][y];
                            arr[x][y] = arr[nx][ny];
                            arr[nx][ny] = temp;
                        }
                    }

                    // 세로 탐색
                    int count = 0;
                    char prev = '-';
                    for (int row = 0; row < N; row++) {
                        if (prev == arr[row][y]) {
                            count++;
                            answer = Math.max(answer, count);
                            continue;
                        }
                        prev = arr[row][y];
                        count = 1;
                    }
                    // 가로 탐색
                    count = 0;
                    prev = '-';
                    for (int col = 0; col < N; col++) {
                        if (prev == arr[x][col]) {
                            count++;
                            answer = Math.max(answer, count);
                            continue;
                        }
                        prev = arr[x][col];
                        count = 1;
                    }


                    // 끝나면 스왑 복구
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (arr[nx][ny] != arr[x][y]) {
                            temp = arr[x][y];
                            arr[x][y] = arr[nx][ny];
                            arr[nx][ny] = temp;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
