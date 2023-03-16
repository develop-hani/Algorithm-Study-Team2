import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * [아이디어]
 * map에 단어와 빈도수를 넣고, list에 단어를 넣어 정렬 기준대로 정렬하였다.
 */

public class Main_20920_영단어암기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 단어장에 단어와 빈도수 넣기
		Map<String, Integer> wordmap = new HashMap<String, Integer>();
		List<String> wordlist = new ArrayList<String>();
		for (int i = 0; i < n; ++i) {
			String word = br.readLine();
			if (word.length() < m) continue;
			
			// 단어가 단어장에 없으면 1, 있으면 빈도수 + 1로 하여 map에 넣기
			if(wordmap.get(word) != null) wordmap.put(word, wordmap.get(word) + 1);
			else{
				wordmap.put(word, 1);
				wordlist.add(word); // list에 단어 넣기
			}
		}
		
		// 정렬 기준에 따라 정렬
		wordlist.sort((o1, o2) -> {
			int f1 = wordmap.get(o1);
			int f2 = wordmap.get(o2);

			if (f1 != f2) return f2 - f1;
			else {
				if(o1.length() != o2.length()) return o2.length() - o1.length();
				else return o1.compareTo(o2);
			}
		});
		
		// 출력
		for (int i = 0; i < wordlist.size(); ++i) {
			sb.append(wordlist.get(i)).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}

}
