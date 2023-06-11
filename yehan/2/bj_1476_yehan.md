# 백준 1476번 날짜 계산
[1476 날짜 계산](https://www.acmicpc.net/problem/1476)

### 문제 이해하기
준규가 사는 나라의 연도를 구하는 문제
 

### 문제 접근 방법
- E <= 15, S <= 28, M <= 19이므로 브루트포스로 가능하다.

### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int year = 0;

		while (!(e <= 0 && s <= 0 && m <= 0)) {
			if(e <= 0) e = 15;
			if(s <= 0) s = 28;
			if(m <= 0) m = 19;
			
			e--; s--; m--;
			year++;
		}

		System.out.println(year);
		sc.close();
	}

}
```
