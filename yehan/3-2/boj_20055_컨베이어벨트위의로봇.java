/*
 * [아이디어]
 * 컨베이어 벨트를 직접 회전 시키지 않고, 올리는 위치와 내리는 위치의 인덱스를 변화시키며 회전하는 효과를 주었다.
 * BufferedWriter를 사용하지 않으면 시간 초과가 났다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트 {

	static int n, k, down, up;
	static int[] durability; // 내구도
	static boolean[] robot; // 로봇의 유무 확인
	static int cnt; // cnt: 내구도가 0인 칸의 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 입력
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		up = 0; down = n - 1; // 올리는 위치와 내리는 위치 저장
		cnt = 0; // 내구도가 0인 칸 세기
		
		st = new StringTokenizer(br.readLine(), " ");
		durability = new int[2 * n];
		for (int i = 0; i < 2 * n; ++i) {
			durability[i] = Integer.parseInt(st.nextToken());
			if (durability[i] == 0) cnt++;
		}
		robot = new boolean[2 * n];

		int ans = 0;

		// 로직
		while (cnt < k) {
			// 1. 벨트 회전
			up = move(up);
			down = move(down);
			if(robot[down]) robot[down] = false; // 내리는 칸에 로봇 내리기
			
			// 2. 로봇 이동
			robotmove();
			if(robot[down]) robot[down] = false; // 내리는 칸에 로봇 내리기
			
			// 3. 올리는 칸에 로봇 올리기
			if(durability[up] > 0) {
				robot[up] = true;
				reduceDurability(up);
			}
			
			ans++;
		}

		// 출력
		bw.write(ans + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	// 벨트 회전 위치 파악
	static int move(int loc) {
		if (loc == 0) return 2 * n - 1;
		else return --loc;
	}
	//로봇 회전 위치 파악
	static void robotmove() {
		for(int i = 1; i < n; ++i) {
			int from = down - i;
			int to = down - i + 1;
			if (from < 0) from += 2 * n;
			if (to < 0) to += 2 * n;
			
			if(!robot[from]) continue; // 이동할 로봇이 없는 경우
			if(robot[to]) continue; // 이동할 칸에 로봇이 있는 경우
			if(durability[to] < 1) continue; // 로봇이 이동할 곳의 내구도가 0인 경우
			robot[from] = false;
			robot[to] = true;
			reduceDurability(to);
		}

	}
	
	static void reduceDurability(int idx) {
		if(--durability[idx] == 0) cnt++;
	}
}
