package algorithm;

public class Edge {
	private int weight;
	private int direct;
	
	public Edge() {
		this.weight = 0;
		this.direct = 0;
	}
	
	public Edge(int weight, int direct) {
		this.weight = weight;
		this.direct = direct;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
}
