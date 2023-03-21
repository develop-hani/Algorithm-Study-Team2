/*
 * [아이디어]
 * 마감시간이 늦은 일들을 먼저 처리하였다.
 * 현재 확인 중인 시간이 6인데, 다음 일이 5분까지 끝나야한다면 시간을 변경하여주었다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6068_시간관리 {

	static class Work implements Comparable<Work> {
		int need;
		int end;

		public Work(int need, int end) {
			super();
			this.need = need;
			this.end = end;
		}

		@Override
		public int compareTo(Work o) {
			return o.end - this.end; // 끝나는게 늦은 것부터 채우기
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Work[] works = new Work[n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(works);
		
		int time = works[0].end;
		for (int i = 0; i < n; ++i) {
			time -= works[i].need;
			if (i + 1 < n && time >= works[i + 1].end) time = works[i + 1].end;
		}
		
		System.out.println(time < 0 ? -1 : time);

		br.close();
	}

}
