package DTU;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ABABAB {
	public static node[][] maze;
	public static int N;

	public static void main(String[] args) {
		var Node = new ABABAB();
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		maze = new node[N][N];

		node node;
		for (int i = 0; i < N; i++) {
			String input = scanner.next();
			for (int j = 0; j < N; j++) {
				node = Node.new node(i, j);
				maze[i][j] = node;
				node.letter = input.charAt(j);

			}
			System.out.println(maze[i]);
		}

	}

	class node {
		int corX;
		int corY;
		node prev;
		int depth;
		char letter;
		boolean visited = false;

		public node(int corX, int corY) {
			this.corX = corX;
			this.corY = corY;

		}

	}

	public int Labyrinth() {
		Queue<node> queue = new LinkedList<>();
		node start = maze[0][0];
		node end = maze[N][N];
		int startX = 0;
		int startY = 0;
		int count = 0;
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		queue.add(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				node cur = queue.poll();
				// try all possible direction
				for (int[] dir : direction) {
					startX += dir[0];
					startY += dir[1];
					// find all cur´s neighbour node
					node neighbour = maze[startX][startY];
					// if not visited and different from the cur´s value
					if (neighbour.visited && neighbour.letter != cur.letter) {
						// mark the adjcent node to visited
						neighbour.visited = true;
						// set the neighbour previous node
						neighbour.prev = cur;
						//add the vaild neighbour to queue
						queue.add(neighbour);
						// distance + 1;
						count += 1;
					}
				}
			}

		}
		return count;
	}

}
