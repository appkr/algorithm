package dev.appkr.algorithm.maze;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;

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
  static final int PATHWAY_COLOUR = 0; // white
  static final int WALL_COLOUR = 1;    // blue
  static final int BLOCKED_COLOR = 2;  // red, 방문해봤지만 "꽝"
  static final int PATH_COLOUR = 3;    // green, 방문했지만 아직 판정이 안된 경우

  static boolean find(int x, int y) {
    if (x < 0 || y < 0 || x >= N || y >= N) {
      return false;
    }

    if (maze[x][y] != PATHWAY_COLOUR) {
      return false;
    }

    if (x == (N - 1) && y == (N - 1)) {
      maze[x][y] = PATH_COLOUR;
      return true;
    }

    maze[x][y] = PATH_COLOUR;
    if (find(x - 1, y) || find(x, y + 1) || find(x + 1, y) || find(x, y - 1)) {
      return true;
    }

    maze[x][y] = BLOCKED_COLOR; // dead end

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
