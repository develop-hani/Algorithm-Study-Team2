/*
처음에 아무 생각 없이 2중 for문을 돌며 부분수열의 시작점과 끝점을 선택하고 모두 계산하는 방법을 사용하였다.
그 결과 시간 초과!!

sequence의 최대 길이가 50만 => dp를 써서 접근해야하는 문제였다.
*/

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int n = sequence.length;
        long max = Math.abs(sequence[0]);
        
        long[] dpp = new long[n];
        long[] dpn = new long[n];
        
        dpp[0] = dpn[0] = sequence[0];
        for(int i = 1; i < n; ++i) {
            if(i % 2 == 1) sequence[i] *= -1; // 펄스 적용
            
            // 커지는 방향 살펴보기
            dpp[i] = Math.max(sequence[i], dpp[i-1] + sequence[i]);
            if(max < Math.abs(dpp[i])) max = Math.abs(dpp[i]);
            
            // 작아지는 방향 살펴보기
            dpn[i] = Math.min(sequence[i], dpn[i-1] + sequence[i]);
            if(max < Math.abs(dpn[i])) max = Math.abs(dpn[i]);
        }
        
        return max;
    }
}