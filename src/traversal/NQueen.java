package traversal;

public class NQueen {
	public static void main(String[] args) {

	}

	private void nQueen(int n) {
		int count = 0;
		Location[] queenLocations = new Location[n];
		for(int i = 0; i < queenLocations.length; i++) {
			queenLocations[i] = new Location(i);
		}
		for (int i = 0; i < queenLocations.length; i++) {
			count = nQueen(queenLocations, 0, count);
		}
		if (count == n) {
			for (int i = 0; i < queenLocations.length; i++) {
				queenLocations[i].showLocation();
			}
		}
	}

	private int nQueen(Location[] queenLocations, int currentRow, int count) {
		for(int i = 0; i < queenLocations.length; i++) {
			queenLocations[currentRow].col = i;
			boolean isAppropriate = true;
			for(int j = 0; j < currentRow; j++) {
				for(int k = 0; k < queenLocations.length; k++) {
					isAppropriate = isAppropriate(queenLocations[j], new Location(j, k));
					if(isAppropriate) {
						count++;
						
					}
				}
			}
		}
		return count;
	}

	private boolean isAppropriate(Location queenLocation, Location currentLocation) {
		boolean sameCol = queenLocation.col == currentLocation.col;
		boolean sameRow = queenLocation.row == currentLocation.row;
		int columnsDistance = queenLocation.col - currentLocation.col;
		int rowsDistance = queenLocation.row - currentLocation.row;
		if (columnsDistance < 0)
			columnsDistance *= -1;
		if (rowsDistance < 0)
			rowsDistance *= -1;
		boolean sameDiagonal = columnsDistance == rowsDistance;
		return (!sameCol) && (!sameRow) && (!sameDiagonal);
	}
}
