/*
모든 토마토가 익는 최소 일수를 구하는 문제라 bfs로 접근했다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {

	static int r, c, h, totalCnt;
	static int[][][] tomato, date;
	static Queue<int[]> q = new ArrayDeque<>();

	// 위, 아래, 앞, 뒤, 왼쪽, 오른쪽 순서
	static int[][] d = { { 0, 0, 1 }, { 0, 0, -1 }, { 0, -1, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 1, 0, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		tomato = new int[r][c][h];
		date = new int[r][c][h];

		for (int hh = 0; hh < h; ++hh) {
			for (int rr = 0; rr < r; ++rr) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int cc = 0; cc < c; ++cc) {
					tomato[rr][cc][hh] = Integer.parseInt(st.nextToken());
					date[rr][cc][hh] = -1;
					if (tomato[rr][cc][hh] == 1) {
						date[rr][cc][hh] = 0;
						q.offer(new int[] { rr, cc, hh });
					} else if (tomato[rr][cc][hh] == 0) {
						totalCnt++;
					}
				}
			}
		}

		System.out.println(bfs());

		br.close();
	}

	private static int bfs() {
		int max = 0;

		while (!q.isEmpty()) {
			if (totalCnt == 0)
				return max;

			int cr = q.peek()[0];
			int cc = q.peek()[1];
			int ch = q.poll()[2];

			for (int dir = 0; dir < d.length; ++dir) {
				int nr = cr + d[dir][0];
				int nc = cc + d[dir][1];
				int nh = ch + d[dir][2];

				if (nr < 0 || nr >= r || nc < 0 || nc >= c || nh < 0 || nh >= h) continue; // 범위를 벗어남
				if (tomato[nr][nc][nh] == -1) continue; // 토마토가 없을 때
				if (date[nr][nc][nh] >= 0) continue; // 이미 방문한 곳

				// 방문 처리하기
				q.offer(new int[] { nr, nc, nh });
				date[nr][nc][nh] = date[cr][cc][ch] + 1;
				max = date[nr][nc][nh];
				totalCnt--;
			}
		}

		return -1;
	}

}
