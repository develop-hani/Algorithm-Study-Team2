/*
[아이디어]
이동할 수 있는 최단경로를 찾아야하므로 bfs를 이용하였다.
String보다는 2차원 배열이 일관성있게 다룰 수 있어 배열로 변경하여 풀었다.
*/

import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0}; // 상하좌우 순
    static int[] dy = {0,0,-1,1};
    
    static char[][] map;
    
    public int solution(String[] board) {
        // 이차원 배열로 변경 + 시작, 종료 위치 찾기
        map = new char[board.length][board[0].length()];
        int[] loc = new int[2]; // 0: 현재 x 좌표, 1: 현재 y 좌표
        int[] destination = new int[2]; // 0: 종료 지점 x 좌표, 1: 종료 지점 y 좌표
        
        for(int i = 0; i < board.length; ++i) {
            map[i] = board[i].toCharArray();
            if(board[i].contains("R")) {
                loc[0] = i;
                loc[1] = board[i].indexOf('R');
            }
            if(board[i].contains("G")) {
                destination[0] = i;
                destination[1] = board[i].indexOf('G');
            }
        }
        
        // bfs로 최단지점 찾기
        return bfs(loc, destination) - 1;
    }
    
    private static int bfs(int[] loc, int[] destination) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[map.length][map[0].length];
        
        q.offer(loc);
        visited[loc[0]][loc[1]] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int dir = 0; dir < 4; ++dir){
                int[] next = move(cur[0], cur[1], dx[dir], dy[dir]);
                
                if(visited[next[0]][next[1]] > 0) continue; // 이미 방문했던 곳
                
                if(next[0] == destination[0] && next[1] == destination[1]) { // 도착 지점에 도달
                    return visited[cur[0]][cur[1]] + 1;
                }
                
                q.offer(next);
                visited[next[0]][next[1]] = visited[cur[0]][cur[1]] + 1;
            }
        }
        
        return 0;
    }
    
    // 이동할 수 있는 지점까지 
    static int[] move(int x, int y, int dx, int dy) {
        int nx = x;
        int ny = y;
        while(true) {
            // 주어진 범위를 벗어나거나 벽에 도달
            if(nx<0||nx>=map.length||ny<0||ny>=map[0].length || map[nx][ny] == 'D') {
                return new int[] {nx - dx, ny - dy};
            }
            nx = nx + dx;
            ny = ny + dy;
        }
    }
}
