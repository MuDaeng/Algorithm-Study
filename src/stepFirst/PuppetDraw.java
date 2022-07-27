package stepFirst;

import java.awt.List;
import java.util.Stack;

public class PuppetDraw {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(new PuppetDraw().solution(board, moves));
	}

	public int solution(final int[][] board, final int[] moves) {
		final Bucket bucket = new Bucket();
		int score = 0;
		for (final int move : moves) {
			final int puppetNum = puppetPick(board, move);
			score = puppetDrop(puppetNum, bucket, score);
		}
		return score;
	}

	private int puppetPick(final int[][] board, final int move) {
		int puppetNum = 0;
		final int empty = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][move - 1] > 0) {
				puppetNum = board[i][move - 1];
				board[i][move - 1] = empty;
				break;
			}
		}
		return puppetNum;
	}

	private int puppetDrop(final int puppetNum, Bucket bucket, int score) {
		if (puppetNum > 0) {
			bucket.push(puppetNum);
			while (getScorePoints(bucket)) {
				bucket.pop();
				bucket.pop();
				score += 2;
			}
		}
		return score;
	}

	private boolean getScorePoints(final Bucket bucket) {
		return (bucket.top > 0 && bucket.secondTop == bucket.top) ? true : false;
	}
}

class Bucket {
	private final Stack<Integer> stack;
	int top;
	int secondTop;

	public Bucket() {
		this.stack = new Stack<>();
	}

	public void push(int e) {
		secondTop = top;
		top = e;
		stack.push(top);
	}

	public int pop() {
		int result = stack.pop();
		if (!stack.empty()) {
			top = stack.peek();
		} else {
			top = 0;
		}
		if (stack.size() > 1) {
			secondTop = stack.elementAt(stack.size() - 2);
		} else {
			secondTop = 0;
		}
		return result;
	}

	public int size() {
		return stack.size();
	}
}
