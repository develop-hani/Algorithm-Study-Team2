/*
조합으로 다이아몬드 곡괭이, 철 곡괭이의 순서를 정하고
순서에 맞춰 광물을 캤을 때 얻는 피로도를 구하였다.
*/

class Solution {
    
    static String[] gokOrder;
    static int diagok, irongok, stonegok;
    static int min = 99999;
    
    public int solution(int[] picks, String[] minerals) {
        diagok = picks[0]; irongok = picks[1]; stonegok = picks[2];
        
        gokOrder = new String[diagok + irongok + stonegok];
        for(int i = 0; i < gokOrder.length; ++i) gokOrder[i] = "";
        
        // 곡괭이 순서 정하기
        selectDiaGok(0, 0, minerals);
        
        return min;
    }
    
    // 다이아몬드 곡괭이 순서 정하기
    private static void selectDiaGok(int cur, int selected, String[] minerals) {
        if(cur > gokOrder.length) return;
        
        if(selected == diagok) {
            selectIronGok(0, 0, minerals);
            return;
        }
        
        for(int i = cur; i < gokOrder.length; ++i) {
            gokOrder[i] = "diamond";
            selectDiaGok(i + 1, selected + 1, minerals);
            gokOrder[i] = "";
        }
    }
    
    // 철 곡괭이 순서 정하기
    private static void selectIronGok(int cur, int selected, String[] minerals) {
        if(cur > gokOrder.length) return;
        
        if(selected == irongok) {
            calc(minerals);
            return;
        }
        
        for(int i = cur; i < gokOrder.length; ++i) {
            if(gokOrder[i] == "diamond") continue;
            gokOrder[i] = "iron";
            selectIronGok(i + 1, selected + 1, minerals);
            gokOrder[i] = "";
        }
    }
    
    private static void calc(String[] minerals) {
        int sum = 0;
        for(int i = 0; i < gokOrder.length; ++i) {
            for(int j = 0; j < 5; ++j) {
                int idx = i * 5 + j;
                if(idx >= minerals.length) break; // 더 이상 캘 광물이 없는 경우
                
                if(gokOrder[i].equals("")) gokOrder[i] = "stone";
                
                if(gokOrder[i].equals("diamond")) {
                    sum += 1;
                } else if(gokOrder[i].equals("iron")) {
                    if(minerals[idx].equals("diamond")) sum += 5;
                    else sum += 1;
                } else {
                    if(minerals[idx].equals("diamond")) sum += 25;
                    else if (minerals[idx].equals("iron")) sum += 5;
                    else sum += 1;
                }
            }
        }
        if(min > sum) {
            for(int i =0;i<gokOrder.length; ++i) System.out.print(gokOrder[i] + " ");
            System.out.println();
            min = sum;
        }
    }
    
}