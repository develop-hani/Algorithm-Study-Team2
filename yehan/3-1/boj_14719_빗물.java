import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [아이디어]
 * 첫번째칸 열과 마지막 열에는 빗물이 고일 수 없다.
 * 두번째 열부터 각각의 열에 고일 수 있는 양을 계산하였다.
 * 확인 중인 열을 기준으로 왼쪽,오른쪽에서 가장 높은 열을 찾았다.
 */


public class Main_14719_빗물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] map = new int[w];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < w; ++i) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;

		for (int now = 1; now < w - 1; ++now) { // now: 확인 중인 열
			int left = 0, right = 0;
			// 현재 위치 기준으로 왼쪽에 높은 지점 확인
			for (int j = 0; j < now; ++j) {
				if(map[j] > map[now] && map[j] > left) left = map[j];
			}

			// 현재 위치 기준으로 오른쪽에 높은 지점 확인
			for (int j = now + 1; j < w; ++j) {
				if(map[j] > map[now] && map[j] > right) right = map[j];
			}
			
			// 현재 열에 고이는 빗물의 양 계산
			int t = Math.min(left, right);
			if(t > map[now]) ans += t - map[now];
		}
		
		System.out.println(ans);

		br.close();
	}

}
