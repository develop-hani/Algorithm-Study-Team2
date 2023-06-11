# 백준 1978번 소수 찾기
[1978번 소수 찾기](https://www.acmicpc.net/problem/1978)

### 문제 이해하기
- 주어진 입력 중 소수의 수를 구한다.
 

### 문제 접근 방법
1. 에라토스테네스의 체를 이용하여 소수를 미리 구한다.
2. 주어진 수 중 소수의 개수를 센다.


### 구현 배경 지식
- 에라토스테네스의 체를 이용한 소수 구하기

### 접근 방법을 적용한 코드
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] nums = new boolean[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;

		Eratos();
		while(n-- > 0) {
			if (nums[Integer.parseInt(st.nextToken())] == false) cnt++;
		}

		System.out.println(cnt);
		br.close();
	}

	static void Eratos() {
		nums[1] = true;
		for (int i = 2; i <= 500; i++) {
			if (nums[i] == true) continue;
			for (int j = i * 2; j <= 1000; j += i) {
				nums[j] = true;
			}
		}
	}
}
```
