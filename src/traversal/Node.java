package traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
	int value;
	private List<Integer> list;
	
	public Node(int value) {
		this.value = value;
		this.list = new ArrayList<Integer>();
	}
	public void addChild(int value) {
		list.add(value);
		list.sort(null);
	}
	public int[] getChilds() {
		int[] arr = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
}
