# 백준 3085번 사탕 게임
[3085 사탕 게임](https://www.acmicpc.net/problem/3085)

### 문제 이해하기
인접한 두 사탕을 한번 스왑해서 같은 색으로 이루어진 
사탕의 가장 긴 연속 부분의 최대값을 구하는 문제


### 문제 접근 방법
- N < 50으로 브루트포스가 가능하다.
- 좌우로 스왑하는 모든 경우, 상하로 스왑하는 모든 경우를 살펴보았다.


### 구현 배경 지식
- 완전탐색

### 접근 방법을 적용한 코드
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	/*
	 * N < 50으로 브루트포스 가능
	 */

	static int n;
	static char[][] candy;
	static int max = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		n = Integer.parseInt(br.readLine());
		candy = new char[n][n];
		for (int i = 0; i < n; i++)
			candy[i] = br.readLine().toCharArray();

		// 로직
		// 좌우로 교환
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				swap(i, j, i, j + 1);
				count();
				swap(i, j, i, j + 1);
			}
		}

		// 상하로 교환
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				swap(j, i, j + 1, i);
				count();
				swap(j, i, j + 1, i);
			}
		}

		// 출력
		System.out.println(max);
		br.close();
	}

	private static void swap(int x1, int y1, int x2, int y2) {
		char tmp = candy[x1][y1];
		candy[x1][y1] = candy[x2][y2];
		candy[x2][y2] = tmp;
	}

	private static void count() {
		// 가로 방향 count
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (candy[i][j] == candy[i][j + 1]) {
					cnt++;
					max = Math.max(max, cnt);
				}
				else cnt = 1;
			}
		}

		// 세로 방향 count
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (candy[j][i] == candy[j + 1][i]) {
					cnt++;
					max = Math.max(max, cnt);
				}
				else cnt = 1;
			}
		}
	}
}
```
