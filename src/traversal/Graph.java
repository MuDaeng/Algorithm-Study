package traversal;

public class Graph {
	Node[] nodes;
	int edgeNum;
	private int startNode;
	public Graph(int nodeNum, int edgeNum, int startNode) {
		this.nodes = new Node[nodeNum];
		for(int i = 0; i < this.nodes.length; i++) {
			this.nodes[i] = new Node(i+1);
		}
		this.edgeNum = edgeNum;
		this.startNode = startNode;
	}
	public int getStartNode() {
		return startNode;
	}
}
