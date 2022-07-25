package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringTest {
	public static void main(String[] args) {
//		int[] arr = new StringTest().solution("110010101001");
//		System.out.print(arr[0] + ", " + arr[1]);
		test();
	}
	static void test() {
		Map<String, Set<String>> id_listMap = new HashMap<String, Set<String>>();
		Map<String, Integer> idIndex = new HashMap<String, Integer>();
		int k = 2;
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		int[] result = new int[id_list.length];
		for(int i = 0; i < id_list.length; i++) {
			idIndex.put(id_list[i], i);
		}
		String[] test1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		for(String index : test1) {
			String[] splitedText = index.split(" ");
			Set<String> curSet = id_listMap.get(splitedText[1]);
			if(curSet == null) {
				curSet = new HashSet<String>();
				id_listMap.put(splitedText[1], curSet);
			}
			curSet.add(splitedText[0]);
		}
		for(String id : id_list) {
			Set<String> idSet = id_listMap.get(id);
			if(idSet != null && idSet.size() >= k) {
				Iterator<String> iterator = idSet.iterator();
				while(iterator.hasNext()) {
					String element = iterator.next();
					result[idIndex.get(element)]++;
				}
			}
		}
		for(int i : result) {
			System.out.print( i + "\t");
		}
	}
}
