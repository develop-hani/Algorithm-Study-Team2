# 백준 1107번 리모콘
[1107 리모콘](https://www.acmicpc.net/problem/1107)

### 문제 이해하기
숫자키가 고장난 리모컨을 이용하여 시청 중인 채널을 이동하고자 할 때, 가장 적게 리모컨 키를 누르는 횟수를 구하는 문제
 

### 문제 접근 방법
- 100에서 시작하여 500,000까지 일일히 +, -를 눌러 이동하는게 이동의 최대값 충분히 브루트포스로 문제를 해결할 수 있다.
- 100번 채널에서 +, -키만 눌러서 이동하는 횟수를 기준으로 하여 비교를 시작하였다.


### 구현 배경 지식
- 완전 탐색

### 접근 방법을 적용한 코드
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n, m;
	static boolean[] broken;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		broken = new boolean[11];
		if (m != 0) {
			String[] tmp = br.readLine().split(" ");
			for (int i = 0; i < m; i++) {
				broken[Integer.parseInt(tmp[i])] = true;
			}
		}

		// 로직
		min = Math.abs(n - 100); // 100에서 +, -만 눌러서 이동하는 경우

		for (int i = 0; i <= 1_000_000; i++) {
			int press = check(i);
			if(press < 0) continue; // i를 숫자키만 눌러서 입력 할 수 있는가?
			press += Math.abs(n - i);// i에서 n까지 +, -만 눌러서 이동하는 횟수
			if(press < min) min = press;
		}

		// 출력
		System.out.println(min);
		br.close();
	}

	private static int check(int num) { // 해당 숫자를 누를 수 있는가? 누를 수 있다면 몇 번 눌러야 하는가?
		int cnt = 0;
		
		if(num == 0 && !broken[0]) return 1; // 예제 6번 - 0번에서 + 누르는 것이 최소인 경우
		else if (num == 0 && broken[0]) return min + 1; // myTestCase1 - 0번이 고장난 경우
		
		while (num > 0) {
			if (broken[num % 10] == true) return -1;
			num /= 10;
			cnt++;
		}
		return cnt;
	}
}
```
