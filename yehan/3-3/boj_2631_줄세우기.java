/*
가장 긴 증가하는 부분수열을 찾고,
해당 부분수열에 포함되지 않은 값들은 모두 이동하면 올바르게 줄을 세울 수 있다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2631_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] child = new int[n];
		for (int i = 0; i < n; ++i) {
			child[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n];
		
		int max = 0;
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (child[i] > child[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(n - max);

		br.close();
	}

}
