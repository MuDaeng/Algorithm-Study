package algorithm;

import java.util.*;
public class PlayMusic {
	Map<String, Integer> map = new HashMap<String, Integer>();
	public PlayMusic() {
		String key =  "key";
		Integer play = 500;
		map.put(key, map.getOrDefault(key, 0) + play);
		map.put(key, map.getOrDefault(key, 0) + play);
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	public static void main(String[] args) {
		PlayMusic pm = new PlayMusic();
	}
}
