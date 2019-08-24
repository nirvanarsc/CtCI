public final class C10Problem5 {

    public static void main(String[] args) {
        final String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        final String[] res = {"at", "ball", "car", "dad"};
        for (String s : res) {
            System.out.println(sparseSearch(strings, s));
        }
    }

    private static int sparseSearch(String[] strings, String s) {
        return Math.max(bsRight(strings, s), bsLeft(strings, s));
    }

    private static int bsRight(String[] strings, String s) {
        int start = 0;
        int end = strings.length;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            while (strings[mid].isEmpty() && mid < end) {
                mid++;
            }

            if (strings[mid].compareTo(s) < 0) {
                start = mid + 1;
            } else if (strings[mid].compareTo(s) > 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int bsLeft(String[] strings, String s) {
        int start = 0;
        int end = strings.length;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            while (strings[mid].isEmpty() && mid > start) {
                mid--;
            }

            if (strings[mid].compareTo(s) < 0) {
                start = mid + 1;
            } else if (strings[mid].compareTo(s) > 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
