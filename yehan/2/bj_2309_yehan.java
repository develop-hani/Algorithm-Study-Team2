/*
조합
아홉명 중 난쟁이에 포함되지 않는 두 명을 선택
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int totalHeight = 0;
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			totalHeight += height[i];
		}
		Arrays.sort(height);

		for (int i = 0; i < 8; i++) {
			for (int j = i; j < 9; j++) {
				if (totalHeight - (height[i] + height[j]) == 100) {
					for (int k = 0; k < 9; k++) {
						if (!(k == i || k == j)) System.out.println(height[k]);
					}
					return;
				}
			}
		}

		sc.close();
	}

}
