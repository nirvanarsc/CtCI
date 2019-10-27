import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public final class C8Problem12 {

    static final int GRID_SIZE = 8;

    public static void main(String[] args) {
        final Integer[] columns = IntStream.rangeClosed(0, GRID_SIZE).boxed().toArray(Integer[]::new);
        final List<Integer[]> res = new ArrayList<>();
        placeQueens(0, columns, res);
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println(res.size());
    }

    static void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                columns[row] = col;
                if (checkValid(columns, row)) {
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    static boolean checkValid(Integer[] columns, int row) {
        for (int i = 0; i < row; i++) {
            final int columnDistance = Math.abs(columns[i] - columns[row]);
            if (columnDistance == 0 || columnDistance == row - i) {
                return false;
            }
        }
        return true;
    }

    private C8Problem12() {
    }
}
