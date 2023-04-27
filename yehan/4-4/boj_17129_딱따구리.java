/*
 * 최단 거리를 구하기 => bfs 이용하여 해결
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17129_딱따구리 {

    static int n, m;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[] start = new int[3]; // 시작점
        for (int i = 0; i < n; ++i) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); ++j) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0; // 시작점부터의 거리
                }
            }
        }
        
        // 로직
        int res = bfs(map, start);
        
        
        // 로직 및 출력
        if (res > 0) sb.append(String.format("TAK\n%d", res));
        else sb.append("NIE");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int[][] map, int[] start) {
        Queue<int[]> q = new ArrayDeque<int[]>();

        map[start[0]][start[1]] = -1;
        q.offer(start);
        while (!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            int cstep = q.poll()[2];

            for (int dir = 0; dir < 4; ++dir) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                int nstep = cstep + 1;
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 1) continue; // 벽
                if (map[nx][ny] == -1 || map[nx][ny] == 2) continue; // 이미 지나간 지점
                
                if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) return nstep;
                
                map[nx][ny] = -1;
                q.offer(new int[] {nx, ny, nstep});
            }
        }
        return -1;
    }

}