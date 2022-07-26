package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchTest {
	public static void main(String[] args) {
		String[] a = {"java backend junior pizza 150", "python frontend senior chicken 210", 
				"python frontend senior chicken 150", "cpp backend senior pizza 260", 
				"java backend junior chicken 80", "python backend senior chicken 50"};
		String[] b = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250","- and backend and senior and - 150",
				"- and - and - and chicken 100","- and - and - and - 150"};
		String[] c = {"- and backend and senior and - 150"};
		int[] result = new SearchTest().solution(a, b);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}
	}
	public int[] solution(String[] info, String[] query) {
		int[] result = new int[query.length];
		for(int i = 0; i < result.length; i++) {
			String[] tokenizer = query[i].split("and ");
			String[] lastToken = tokenizer[tokenizer.length - 1].split(" ");
			tokenizer[tokenizer.length - 1] = lastToken[0];
			int score = Integer.parseInt(lastToken[1]);
			ArrayList<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList(info));
			for(int j = 0; j < tokenizer.length; j++) {
				if(!tokenizer[j].contains("-")) {
					int x = j;
					list.removeIf(n -> (!n.contains(tokenizer[x])));	
				}
			}
			int[] tmpList = new int[list.size()];
			for(int j = 0; j < tmpList.length; j++) {
				String tmp = list.get(j).replaceAll("[^0-9]", "");
				tmpList[j] = Integer.parseInt(tmp);
			}

			for(int j = 0; j < tmpList.length; j++) {
				if(tmpList[j] >= score) result[i]++;
			}
		}
		return result;
	}
}
