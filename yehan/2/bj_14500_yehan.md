# 백준 14500번 테트로미노
[14500번 테트로미노](https://www.acmicpc.net/problem/14500)

### 문제 이해하기
2차원 배열에 테트로미노를 둘 때, 테트로미노가 놓인 칸의 합의 최댓값을 구하는 문제

### 문제 접근 방법
- 연속되게 표현할 수 있는 테트로미노는 DFS를 통해 최댓값을 탐색한다.
- 연속되게 표현할 수 없는 ㅜ모양의 경우 브루트포스를 통해 최댓값을 탐색한다.

### 구현 배경 지식
- DFS
- 브루트포스

### 접근 방법을 적용한 코드
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int max = -1;
    
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 로직
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                continuous(0, i, j, 0);
            }
        }
        
        oo();
        
        // 출력
        System.out.println(max);

        br.close();
    }


    private static void continuous(int cnt, int x, int y, int sum) { // 1. 연속적으로 처리할 수 있는 -, ㅁ, L, ... 처리
        if(cnt == 4) {
            if(sum > max) max = sum;
            return;
        }
        
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (visited[x][y]) return;
        
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) continuous(cnt + 1, x + dx[k], y + dy[k], sum + arr[x][y]);
        visited[x][y] = false;
    }

    private static void oo() { // 2. 연속적으로 처리할 수 없는 ㅗ모양 처리
        // ㅗ, ㅜ
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m - 1; j++) {
				int base = arr[i][j - 1] + arr[i][j] + arr[i][j+1];
				if (i - 1 >= 0 && base + arr[i - 1][j] > max) max = base + arr[i - 1][j]; // ㅗ
				if (i + 1 < n && base + arr[i + 1][j] > max) max = base + arr[i + 1][j]; // ㅜ      	
            }
        }

        
        // ㅓ, ㅏ
		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n - 1; i++) {
				int base = arr[i - 1][j] + arr[i][j] + arr[i + 1][j];
				if (j - 1 >= 0 && base + arr[i][j - 1] > max) max = base + arr[i][j - 1]; // ㅓ
				if (j + 1 < m && base + arr[i][j + 1] > max) max = base + arr[i][j + 1]; // ㅏ
			}
		}
    }
}
```
