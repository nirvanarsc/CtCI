public final class C8Problem10 {

    static boolean paintFill(int[][] arr, int x, int y, int color, int oldColor) {
        if (x < 0 || y < 0 || x >= arr[0].length || y >= arr.length) {
            return false;
        }

        if (arr[x][y] == oldColor) {
            arr[x][y] = color;
            paintFill(arr, x + 1, y, color, oldColor);
            paintFill(arr, x, y + 1, color, oldColor);
            paintFill(arr, x, y - 1, color, oldColor);
            paintFill(arr, x - 1, y, color, oldColor);
        }

        return true;
    }

    private C8Problem10() {
    }
}
