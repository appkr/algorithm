package dev.appkr.algorithm.maze;

public class Maze {

  static int N = 8;
  static int[][] maze = {
      {0, 0, 0, 0, 0, 0, 0, 1},
      {0, 1, 1, 0, 1, 1, 0, 1},
      {0, 0, 0, 1, 0, 0, 0, 1},
      {0, 1, 0, 0, 1, 1, 0, 0},
      {0, 1, 1, 1, 0, 0, 1, 1},
      {0, 1, 0, 0, 0, 1, 0, 1},
      {0, 0, 0, 1, 0, 0, 0, 1},
      {0, 1, 1, 1, 0, 1, 0, 0}
  };
  static final int PATHWAY = 0;  // 통로
  static final int WALL = 1;     // 벽
  static final int BLOCKED = 2;  // 방문해봤지만 "꽝"
  static final int SOLUTION = 3; // 솔루션

  static boolean find(int x, int y) {
    if (x < 0 || y < 0 || x >= N || y >= N) {
      return false;
    }

    if (maze[x][y] != PATHWAY) {
      return false;
    }

    if (x == (N - 1) && y == (N - 1)) {
      maze[x][y] = SOLUTION;
      return true;
    }

    maze[x][y] = SOLUTION;
    if (find(x - 1, y) || find(x, y + 1) || find(x + 1, y) || find(x, y - 1)) {
      return true;
    }

    maze[x][y] = BLOCKED; // dead end

    return false;
  }

  public static void main(String[] args) {
    print(maze);
    find(0, 0);
    print(maze);
  }

  static void print(int[][] maze) {
    for(int i = 0; i < maze.length; i++) {
      for(int j = 0; j < maze[i].length; j++) {
        System.out.print(maze[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
