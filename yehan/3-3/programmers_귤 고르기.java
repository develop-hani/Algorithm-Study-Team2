/*
[아이디어]
각 크기의 귤이 몇 개씩 있는지 파악한다.
개수가 많은 귤부터 차례대로 박스를 채우기 시작하면 가장 적은 크기의 귤을 사용할 수 있다.

[사용한 변수]
key: 어떤 크기의 귤들이 있는지 저장하였다.
map: 각 크기의 귤들이 몇 개씩 있는지 살펴본다. key가 귤의 크기, value가 귤의 개수를 의미한다.
list: 각 크기의 귤을 개수가 많은 순서대로 정렬하기 위해 사용하였다.
*/

import java.util.*;

class Solution {
    static class Tang implements Comparable<Tang> {
        int size;
        int count;
        
        Tang(int size, int count) {
            this.size = size;
            this.count = count;
        }
        
        public int compareTo(Tang t) {
            return t.count-this.count;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // 각 크기의 귤이 몇개씩 있는지 파악하기
        // key: 크기, vlaue: 개수
        List<Integer> key = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; ++i) {
            if(map.containsKey(tangerine[i])) {
                 map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
                key.add(tangerine[i]);
            }
        }
        
        List<Tang> list = new ArrayList<>();
        for(int i = 0; i < key.size(); ++i) {
            int size = key.get(i);
            list.add(new Tang(size, map.get(size)));
        }
        
        // 개수 순으로 정렬
        Collections.sort(list);
        
        // 개수가 많은 것부터 보기
        for(int i = 0; i < list.size(); ++i) {
            if(k<=0) return answer;
            k -= list.get(i).count;
            answer++;
        }
        return answer;
    }
}
