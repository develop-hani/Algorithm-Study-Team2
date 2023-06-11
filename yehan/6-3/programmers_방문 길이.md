# [프로그래머스 49994번 방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994)

### 🤔 문제 이해하기

1. 캐릭터는 사방으로 이동할 수 있다.
2. 캐릭터는 10 x 10의 주어진 범위 내에서만 이동할 수 있다.
3. 이동 가능한 횟수 <= 500

### 📖 스토리 라인

1. 좌우 방향의 이동 여부와 상하 방향의 이동 여부를 각각 파악한다.
2. 현재위치와 이동할 위치를 파악하여 주어진 범위 내에서 움직이는지 파악한다.

### 💻 문제를 해결한 코드

```java
class Solution {

    // LRDU 순서
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] LR = new boolean[10][11];
    static boolean[][] UD = new boolean[11][10];

    public int solution(String dirs) {
        int answer = 0;

        // 현재 위치
        int cx = 5; int cy = 5;
        for (int i = 0; i < dirs.length(); ++i) {
            char dirCh = dirs.charAt(i);
            int dir = -1;

            switch(dirCh) {
                case 'L': dir = 0;
                        break;
                case 'R': dir = 1;
                        break;
                case 'D' : dir = 2;
                        break;
                case 'U': dir = 3;
                        break;
            }

            // 다음 위치
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue; // 주어진 범위를 벗어난 경우

            // 좌우 방향으로 이미 지나간 길인지 확인
            if (dir == 0 || dir == 1) {
                int xx = cx < nx ? cx : nx;
                int yy = cx < nx ? cy : ny;
                if (!LR[xx][yy]) {
                    // System.out.println(i + "번째 | " + dirCh + "방향 | " + cx + " " + cy + " " + nx + " "+ ny + " ");
                    answer++;
                    LR[xx][yy] = true;
                }
            }

            // 상하 방향으로 이미 지나간 길인지 확인
            if (dir == 2 || dir == 3) {
                int xx = cy < ny ? cx : nx;
                int yy = cy < ny ? cy : ny;
                if (!UD[xx][yy]) {
                    // System.out.println(i + "번째 | " + dirCh + "방향 | " + cx + " " + cy + " " + nx + " "+ ny + " ");
                    answer++;
                    UD[xx][yy] = true;
                }
            }

            cx = nx; cy = ny;
        }

        return answer;
    }
}
```
