import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class C8Problem12 {

    static final int GRID_SIZE = 8;

    public static void main(String[] args) {
        final Integer[] columns = IntStream.rangeClosed(0, GRID_SIZE).boxed().toArray(Integer[]::new);
        final List<Integer[]> res = new ArrayList<>();
        placeQueens(0, columns, res);
        res.forEach(C8Problem12::printArr);
        System.out.println(res.size());
    }

    static void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    static boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            final int column2 = columns[row2];
            if (column1 == column2) {
                return false;
            }

            final int columnDistance = Math.abs(column2 - column1);
            final int rowDistance = row1 - row2;
            if (columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    private static void printArr(Integer[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    private C8Problem12() {
    }
}
