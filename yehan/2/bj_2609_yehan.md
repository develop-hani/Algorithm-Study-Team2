# 백준 2609번 최대공약수와 최소공배수
[2609번 최대공약수와 최소공배수](https://www.acmicpc.net/problem/2609)

### 문제 이해하기
- 두 자연수를 입력 받아 최대 공약수와 최소 공배수를 출력한다.

### 문제 접근 방법
1. 유클리드 호제법을 이용하여 최대공약수를 구한다.
2. <1.>에서 구한 최대공약수를 이용하여 최소공배수를 구한다.

### 구현 배경 지식
- 유클리드 호제법

### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		lcm(a, b);

		sc.close();
	}

	static int gcd(int a, int b) { // 최대공약수
		int tmp = 0;
		while (a > 0) {
			tmp = b % a;
			b = a;
			a = tmp;
		}
		System.out.println(b);
		return b;
	}

	static void lcm(int a, int b) { // 최소공배수
		System.out.println(a * b / gcd(a, b));
	}
}

```
