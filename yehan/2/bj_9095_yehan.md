# 백준 9095 1,2,3 더하기
[9095 1, 2, 3 더하기](https://www.acmicpc.net/problem/9095)

### 문제 이해하기
1, 2, 3의 수만 사용하여 해당 정수를 나타낼 수 있는 모든 경우의 수를 구하는 문제
 

### 문제 접근 방법
- 해당 문제의 일반식을 찾아 DP로 해결하고자 하였다.
`dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];`

### 구현 배경 지식
- 다이나믹 프로그래밍


### 접근 방법을 적용한 코드
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] dp = new int[11];
	static int max = 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int n = Integer.parseInt(br.readLine());

			if (n > max) solve(n);

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	private static void solve(int n) {
		for (int i = max + 1; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		max = n;
	}
}
```
