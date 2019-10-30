package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int value;
	private List<Edge> edge;
	
	public Node() {
		edge = new ArrayList<Edge>();
	}
	public Node(int value) {
		this();
		this.value = value;
	}
	public void addEdge(Edge edge) {
		this.edge.add(edge);
	}
	
	public int getValue() {
		return value;
	}

	public void setEdge(List<Edge> edge) {
		this.edge = edge;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Edge> getEdge(){
		return this.edge;
	}
	public boolean isWised(int direct) {
		for(Edge item : this.edge) {
			if(item.getDirect() == direct) return true;
		}
		return false;
	}
	public void showEdge() {
		System.out.print(value + "의 인접리스트");
		for(Edge item : edge) {
			System.out.print(" -> " + item.getDirect() + ":" + item.getWeight());
		}
		System.out.println();
	}
}