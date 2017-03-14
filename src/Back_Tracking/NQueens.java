/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/#/description
 *
 */

class Position {
	int row, col;
	public Position (int row, int col) {
		this.row = row;
		this.col = col;
	}
}


public class Solution {
	public List<List<Position>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
	    List<Position> positions = new ArrayList<>();
	    util(n, 0, positions);

	    List<List<String>> ans = new ArrayList<>();
	    for (int i=0; i < res.size(); i++) {
	    	ans.add(printBoard(res.get(i)));
	    }

	    return ans;
	}

	public void util(int n, int row, List<Position> positions) {
		if (row >= n) {
			res.add(new ArrayList<>(positions));
		} else {
			for (int col=0; col < n; col++) {
				boolean validPos = true;

				for (Position queen : positions) {
					if (queen.col == col || queen.row - queen.col == row - col || 
						queen.row + queen.col == row + col) {
						validPos = false;
						break;
					}
				}

				if (validPos) {
					Position pos = new Position(row, col);
					positions.add(pos);
					util(n, row+1, positions);
					positions.remove(positions.size() - 1);
				}
			}
		}
	}

	public List<String> printBoard(List<Position> positions) {
		List<String> res = new ArrayList<>();
		int rows = positions.size();

		for (Position pos : positions) {
			res.add(printRow(rows, pos));
		}

		return res;
	}

	public String printRow(int rows, Position pos) {
		StringBuilder sb = new StringBuilder();

		for (int i=0; i < rows; i++) {
			if (i == pos.col) {
				sb.append("Q");
			}
			else {
				sb.append(".");
			}
		}

		return sb.toString();
	}
}