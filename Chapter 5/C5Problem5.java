import java.util.stream.IntStream;

public final class C5Problem5 {

    private C5Problem5() {
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 100).forEach(i -> System.out.println(i + " " + isPowerOf2(i)));
    }

    static boolean isPowerOf2(int num) {
        return (num & (num - 1)) == 0;
    }
}
