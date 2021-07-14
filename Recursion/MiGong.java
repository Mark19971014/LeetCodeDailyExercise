package Recursion;

public class MiGong {
	public static void main(String[] args) {
		// create a 2D array to simlate maze
		int[][] map = new int[8][7];
		// use 1 respent wall
		// put 1 in up and down boundary
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		// create left and right wall
		for (int j = 0; j < 8; j++) {
			map[j][0] = 1;
			map[j][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		
		// print map
		System.out.println("current map");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		// find way for ball via recusion
		setWay(map, 1, 1);
		// return new wap, the way that ball walked and labeled
		System.out.println("new map");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	/*
	 * i ,j represnt the start point; if ball can reach ,map[6][5], then way found
	 * if map[i][j] = 0 then not visited.2 means way is vaild, 3 means way is visied
	 * but invaild make a direction stragegy: down -> right->up->left
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {
			// if the current point not visited
			if (map[i][j] == 0) {
				// foloww stragegy
				map[i][j] = 2; // assume the point is vaild
				if (setWay(map, i + 1, j)) { // down
					return true;
				} else if (setWay(map, i, j + 1)) {// right
					return true;
				} else if (setWay(map, i - 1, j)) {// up
					return true;
				} else if (setWay(map, i, j - 1)) {// left
					return true;
				} else { // current node is invalid
					map[i][j] = 3;
					return false;
				}
			} else { // map[i][j] != 0 ,map is either 1, 2 or 3
				return false;

			}
		}
	}

	public static boolean setWay2(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {
			// if the current point not visited
			if (map[i][j] == 0) {
				// foloww stragegy
				map[i][j] = 2; // assume the point is vaild
				if (setWay2(map, i - 1, j)) { // down
					return true;
				} else if (setWay2(map, i, j + 1)) {// right
					return true;
				} else if (setWay2(map, i + 1, j)) {// up
					return true;
				} else if (setWay2(map, i, j - 1)) {// left
					return true;
				} else { // current node is invalid
					map[i][j] = 3;
					return false;
				}
			} else { // map[i][j] != 0 ,map is either 1, 2 or 3
				return false;

			}
		}
	}
}