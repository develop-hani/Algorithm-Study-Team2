/*
 * [아이디어]
 * 조합으로 팀을 나누고, 나눈 팀의 점수를 계산하여 차가 최소가 되는 값을 구한다.
 * 
 * teamA: 0,1,2, teamB: 3,4,5 / teamA: 3,4,5, teamB: 0,1,2 는 같은 경우이므로
 * 중복 계산을 줄이기 위해 0번 사람은 항상 teamA에 속하도록 하였다.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14889_스타트와링크 {

	static int min = Integer.MAX_VALUE;
	static int[][] score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int n = Integer.parseInt(br.readLine());

		score = new int[n][n];
		for (int i = 0; i < n; ++i) {
			score[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// 조합으로 팀 나누기 (0번 사람은 항상 teamA에 속한다.)
		combination(n, 1, new boolean[n], 1);
		
		// 출력 및 종료
		System.out.println(min);
		br.close();
	}

	// 조합을 통해 팀을 나누는 함수
	// cnt: 현재 고려한 사람의 수, cntteam: teamA에 속한 사람의 수
	// team이 false이면 teamA, true이면 teamB
	private static void combination(int n, int cnt, boolean[] team, int cntteam) {
		if (n == cnt) {
			if (cntteam != n / 2)
				return; // 한쪽팀에 사람이 몰린 경우

			// 점수 계산하기
			int teamA = 0; int teamB = 0;
			for (int i = 0; i < n - 1; ++i) {
				for (int j = i + 1; j < n; ++j) {
					if(team[i] ^ team[j]) continue; // 둘이 다른 팀
					if(!team[i]) { // 둘이 teamA에 속하면
						teamA += score[i][j];
						teamA += score[j][i];
					} else { // 둘이 teamB에 속하면
						teamB += score[i][j];
						teamB += score[j][i];
					}
				}
			}
			// 점수의 차가 최소가 되는지 확인
			if(Math.abs(teamA - teamB) < min) min = Math.abs(teamA - teamB);

			return;
		}

		// 현재 사람을 teamA에 넣기
		team[cnt] = false;
		combination(n, cnt + 1, team, cntteam + 1);
		// 현재 사람을 teamB에 넣기
		team[cnt] = true;
		combination(n, cnt + 1, team, cntteam);
	}

}
