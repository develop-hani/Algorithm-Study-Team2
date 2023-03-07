import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj_2309_lyj {
    static int[] numbers;
    static int[] arr;
    static List<int[]> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        numbers = new int[7];
        answer = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        combination(0, 0);

        for (int i = 0; i < answer.get(0).length; i++) {
            System.out.println(answer.get(0)[i]);
        }
    }

    static void combination(int depth, int start) {
        if (depth == numbers.length) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if (sum == 100) {
                int[] newArr = Arrays.copyOfRange(numbers, 0, numbers.length);
                Arrays.sort(newArr);
                answer.add(newArr);
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            numbers[depth] = arr[i];
            combination(depth + 1, i + 1);
        }
    }
}
