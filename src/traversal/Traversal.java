package traversal;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Traversal {
	public static void main(String[] args) {
		new Traversal().showTraversal();
	}
	public void showTraversal() {
		Graph graph = inputGraphVal();
		dfs(graph);
		dfsRecur(graph);
		bfs(graph);
	}

	private void dfs(Graph graph) {
		System.out.print("DFS  :  ");
		Stack<Node> stack = new Stack<>();
		stack.push(graph.nodes[graph.getStartNode() - 1]);
		boolean[] isVisited = new boolean[graph.nodes.length];
		do {
			Node next = stack.pop();
			if(isVisited[next.value - 1]) {
				continue;
			}
			for (int i = next.getChilds().length - 1; i >= 0; i--) {
				if (isVisited[next.getChilds()[i] - 1]) {
					continue;
				} else {
					stack.push(graph.nodes[next.getChilds()[i] - 1]);
				}
			}
			if(!isVisited[next.value - 1]) {
				System.out.print(next.value + "\t");
				isVisited[next.value - 1] = true;
			}
		} while (stack.size() != 0);
		System.out.println();
	}
	
	private void dfsRecur(Graph graph) {
		System.out.print("DFSRecursive  :  ");
		Stack<Node> stack = new Stack<>();
		boolean[] isVisited = new boolean[graph.nodes.length];
		Node node = graph.nodes[graph.getStartNode() - 1];
		isVisited[graph.getStartNode() - 1] = true;
		dfsRecur(graph, node, isVisited);
		System.out.println();
	}
	
	private void dfsRecur(Graph graph, Node node, boolean[] isVisited) {
		System.out.print(node.value + "\t");
		for(int i = 0; i < node.getChilds().length; i++) {
			if(!isVisited[node.getChilds()[i] - 1]) {
				isVisited[node.getChilds()[i] - 1] = true;
				dfsRecur(graph, graph.nodes[node.getChilds()[i] - 1], isVisited);
			}
		}
	}
	
	private void bfs(Graph graph) {
		System.out.print("BFS  :  ");
		LinkedList<Node> queue = new LinkedList<>();
		queue.offer(graph.nodes[graph.getStartNode() - 1]);
		boolean[] isVisited = new boolean[graph.nodes.length];
		do {
			Node next = queue.poll();
			for (int i = 0; i < next.getChilds().length; i++) {
				boolean isInStack = false;
				for (int j = 0; j < queue.size(); j++) {
					if (next.getChilds()[i] == queue.get(j).value) {
						isInStack = true;
						break;
					}
				}
				if (isInStack || isVisited[next.getChilds()[i] - 1]) {
					continue;
				} else {
					queue.offer(graph.nodes[next.getChilds()[i] - 1]);
				}
			}
			isVisited[next.value - 1] = true;
			System.out.print(next.value + "\t");
		} while (queue.size() != 0);
		System.out.println();
	}

	private Graph inputGraphVal() {
		Scanner scanner = null;
		Graph graph = null;
		try {
			scanner = new Scanner(System.in);
			int nodeNum = scanner.nextInt();
			int edgeNum = scanner.nextInt();
			int startNode = scanner.nextInt();
			graph = new Graph(nodeNum, edgeNum, startNode);
			for (int i = 0; i < edgeNum; i++) {
				int val = scanner.nextInt();
				int edge = scanner.nextInt();
				graph.nodes[val - 1].addChild(edge);
				graph.nodes[edge - 1].addChild(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			return graph;
		}
	}
}
