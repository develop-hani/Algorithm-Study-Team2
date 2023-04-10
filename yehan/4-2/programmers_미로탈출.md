# 프로그래머스 미로탈출

[프로그래머스 미로탈출 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/159993#)

### 문제 이해하기

1. 미로를 탈출하기 위한 최소 시간을 구한다.
2. 5 <= 미로의 행, 열 길이 <= 100

### 문제 접근 방법

1. **bfs**
   최소 시간을 구하는 문제이므로 bfs를 이용하여 해결
   visited배열을 3차원으로 구성
   </br>
   visited[type][x][y]에서
   - `type == 0`이면 레버를 찾기 위한 bfs
   - `type == 1`이면 레버를 찾은 후 출구를 찾기 위한 bfs

### 문제를 해결한 코드

```java
import java.util.*;
class Solution {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[] start = null;
        char[][] map = new char[n][m];

        for(int i = 0; i < n; ++i) {
            map[i] = maps[i].toCharArray();
            for(int j = 0; j < m; ++j) {
                if(map[i][j] == 'S') start = new int[] {i, j, 0};
            }
        }

        // bfs 시작
        Queue<int[]> q = new LinkedList<>();
        int[][][] visited = new int[2][n][m]; // 0: 레버 찾으러 가는 길, 1: 문 찾으러 가는 길
        q.offer(start);
        visited[0][start[0]][start[1]] = 1;
        int stat = 0;

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int prevStat = q.poll()[2];

            for(int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 'X') continue;
                if(visited[stat][nx][ny] > 0) continue; // 이미 방문한 곳
                if(prevStat != stat) continue; // 레버를 찾은 경우, 레버를 찾지 않았을 상황은 탐색할 필요 없음

                if(prevStat == 0 && map[nx][ny] == 'L') { // 레버 발견!
                    stat = 1;
                    visited[1][nx][ny] = visited[0][x][y] + 1;
                    q.offer(new int[] {nx, ny, stat});
                }
                else if(prevStat == 1 && map[nx][ny] == 'E') { // 출구 발견!
                    return visited[stat][x][y];
                }
                else {
                    visited[stat][nx][ny] = visited[stat][x][y] + 1;
                    q.offer(new int[] {nx, ny, stat});
                }

            }
        }

        return -1;
    }

}
```
