/*
 * [아이디어]
 * bfs로 최단 경로를 탐색해가며 해당 숫자에 도달하기 위해 어느 경로를 통해 왔는지 배열에 저장해 두었다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_21852_1로만들기2 {

	static int[] min; // 각 값에 도달하는 최솟값 기록
	static int[] dp; // 각 값에 도달한 경로 기록

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		min = new int[n + 1];
		dp = new int[n + 1];

		bfs(n);

		sb.append(min[1]).append("\n");

		// 경로를 추적해나감
		List<Integer> route = new ArrayList<>();
		route.add(1);
		for (int i = 1; dp[i] != 0;) {
			route.add(i = dp[i]);
		}

		for (int i = route.size() - 1; i >= 0; --i) {
			sb.append(route.get(i)).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(n);

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now % 3 == 0) {
				if (min[now / 3] == 0 || min[now / 3] > min[now] + 1) {
					min[now / 3] = min[now] + 1;
					dp[now / 3] = now;
					q.offer(now / 3);
				}
			}
			if (now % 2 == 0) {
				if (min[now / 2] == 0 || min[now / 2] > min[now] + 1) {
					min[now / 2] = min[now] + 1;
					dp[now / 2] = now;
					q.offer(now / 2);
				}
			}
			if (now - 1 >= 1) {
				if (min[now - 1] == 0 || min[now - 1] > min[now] + 1) {
					min[now - 1] = min[now] + 1;
					dp[now - 1] = now;
					q.offer(now - 1);
				}
			}
		}
	}

}
