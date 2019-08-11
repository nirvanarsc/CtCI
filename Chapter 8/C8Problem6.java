import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class C8Problem6 {

    public static void main(String[] args) {
        final int n = 20;
        final List<Integer> integers = IntStream.iterate(n, x -> --x).limit(n).boxed().collect(Collectors.toList());
        final Stack<Integer> left = new Stack<>();
        final Stack<Integer> mid = new Stack<>();
        final Stack<Integer> right = new Stack<>();
        left.addAll(integers);

        printStacks(left, mid, right);
        towersOfHanoi(left, mid, right, n);
        printStacks(left, mid, right);
    }

    static void towersOfHanoi(Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination, int n) {
        if (n <= 0) {
            return;
        }
        towersOfHanoi(origin, destination, buffer, n - 1);
        destination.push(origin.pop());
        towersOfHanoi(buffer, origin, destination, n - 1);
    }

    static void printStacks(Stack<Integer> left, Stack<Integer> mid, Stack<Integer> right) {
        System.out.println(left);
        System.out.println(mid);
        System.out.println(right);
        System.out.println();
    }

    private C8Problem6() {
    }
}
