package traversal;

public class Location {
	int row;
	int col;
	public Location(int row) {
		this.row = row;
		this.col = -1;
	}
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public void showLocation() {
		System.out.println("< " + row + " , " + col + " >");
	}
}
