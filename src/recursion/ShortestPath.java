package recursion;

import java.util.LinkedList;

public class ShortestPath {

	/**
	 * Given a maze in the form of the binary rectangular matrix, find length of the
	 * shortest path in maze from given source to given destination. The path can
	 * only be constructed out of cells having value 1 and at any given moment, we
	 * can only move one step in one of the four directions.
	 * 
	 * 
	 * 
	 * 
	 */

	public static boolean findShortestPath(int[][] matrix, LinkedList<int[]> visited, int dx, int dy, int sx, int sy) {

//		if the current cell is outside the maze
//        return false (you are out of bounds)
		if (sx < 0 || sx > matrix.length -1 || sy < 0 || sy > matrix[sx].length -1) {
			return false;
		}
		// else if the current cell is part of the barrier or has been visited already
		// return false (you are off the path or in a cycle)
		else if (matrix[sx][sy] == 0 || matrix[sx][sy] == -1) {
			return false;
		}
		// else if the current cell is the maze exit
		// recolor it to the path color and return true (you have successfully
		// completed the maze)
		else if (sx == dx && sy == dy) {
			matrix[sx][sy] = -1;
			visited.add(new int[] {sx, sy});
			return true;
		} else { // Try to find a path from the current path to the exit:
			// mark the current cell as on the path by recoloring it to the path color
			matrix[sx][sy] = -1;
			visited.add(new int[] {sx, sy});
			// for each neighbor of the current cell
			findShortestPath(matrix, visited, dx, dy, sx, sy + 1); // North
			findShortestPath(matrix, visited, dx, dy, sx, sy - 1); // South
			findShortestPath(matrix, visited, dx, dy, sx + 1, sy); // East
			findShortestPath(matrix, visited, dx, dy, sx - 1, sy); // West
		}
		
		return false;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 }, { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 }, };

		// construct a matrix to keep track of visited cells
		LinkedList<int[]> visited = new LinkedList<int[]>();

		boolean min_dist = findShortestPath(mat, visited, 7, 5, 0, 0);

		if (min_dist == true) {
			System.out.println("The shortest path from source to destination " + "has length " + visited.size());
		} else {
			System.out.println("Destination can't be reached from source");
		}
	}

}
