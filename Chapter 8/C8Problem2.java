import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C8Problem2 {

    static class Point {
        int row;
        int col;

        Point(int r, int c) {
            row = r;
            col = c;
        }
    }

    // Book solution
    @Nullable List<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        final List<Point> path = new ArrayList<>();
        final Set<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, List<Point> path, Set<Point> failedPoints) {
        // If out of bounds or not available, return.
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        final Point p = new Point(row, col);

        //If we've already visited this cell, return.
        if (failedPoints.contains(p)) {
            return false;
        }

        final boolean isAtOrigin = (row == 0) && (col == 0);

        //If there's a path from start to my current location, add my location.
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p); // Cache result
        return false;
    }
}
