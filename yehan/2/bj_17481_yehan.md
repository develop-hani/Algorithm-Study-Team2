# 백준 17427번 약수의 합
[17427번 약수의 합](https://www.acmicpc.net/problem/17427)

### 문제 이해하기
- x보다 작거나 같은 모든 자연수 y의 약수의 합을 더한 값은 g(x)이다.
 

### 문제 접근 방법
- x보다 작은 모든 자연수 y에 대해 약수를 구하고 더하고자 한다면 O( $N^2$ )의 시간 복잡도를 가진다. </br>
  N은 최대 1,000,000이므로 제한된 시간 안에 해결할 수 없다. </br>
  
  1을 약수로 가지는 수는 N / 1개 </br>
  2를 약수로 가지는 수는 N / 2개 </br>
  ... </br>
  N을 약수로 가지는 수는 N / N개 </br>
  임을 고려하여 문제를 해결할 수 있다.
- 합의 최대 값은 int 범위를 벗어나므로 long long 타입의 변수를 사용한다.

### 구현 배경 지식
- 약수

### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long g = 0;

		for (int i = 1; i <= n; i++) {
			g += i * (n / i);
		}
		
		System.out.println(g);

		sc.close();
	}

}
 
```
