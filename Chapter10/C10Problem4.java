public class C10Problem4 {

    static class Listy {
        int elementAt(int i) {
            return i;
        }
    }

    int search(Listy list, int value) {
        int idx = 1;
        while (list.elementAt(idx) != -1 && list.elementAt(idx) < value) {
            idx *= 2;
        }
        return binarySearch(list, value, idx / 2, idx);
    }

    int binarySearch(Listy list, int value, int start, int end) {
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            final int middle = list.elementAt(mid);
            if (middle < value) {
                start = mid + 1;
            } else if (middle == -1 || middle > value) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
