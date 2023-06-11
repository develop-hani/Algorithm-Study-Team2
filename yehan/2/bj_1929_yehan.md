# 백준 문제번호 문제제목
[1929_소수구하기](https://www.acmicpc.net/problem/1929)

### 문제 이해하기
- 입력받은 M, N에 대하여 해당 범위 안에 있는 소수를 출력한다.
 

### 문제 접근 방법
1. 에라토스테네스의 체를 이용하여 주어진 범위 내의 소수를 구한다.


### 구현 배경 지식
- 에라토스테네스의 체를 이용한 소수 판별

### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] prime = new boolean[m + 1];

		// 에라토스테네스의 체
		prime[1] = true;
		for (int i = 2; i <= m / 2; i++) {
			for (int j = i * 2; j <= m; j += i) {
				prime[j] = true;
			}
		}

		for (int i = n; i <= m; i++) {
			if (prime[i] == false) System.out.println(i);
		}
		sc.close();
	}

}
```
