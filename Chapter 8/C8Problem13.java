import org.jetbrains.annotations.Nullable;

import java.util.List;

public class C8Problem13 {

    static class Box {
        int height;
        int width;
        int depth;

        boolean canBeAbove(Box other) {
            return height > other.height && width > other.width && depth > other.depth;
        }
    }

    int createStack(List<Box> boxes) {
        boxes.sort((x, y) -> Integer.compare(y.height, x.height));
        int maxHeight = 0;
        final int[] stackMap = new int[boxes.size()];

        for (int i = 0; i < boxes.size(); i++) {
            final int height = createStack(boxes, i, stackMap);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }

    int createStack(List<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        final Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                final int height = createStack(boxes, i, stackMap);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottom.height;
        stackMap[bottomIndex] = maxHeight;
        return maxHeight;
    }

    int createStack2(List<Box> boxes) {
        boxes.sort((x, y) -> Integer.compare(y.height, x.height));
        final int[] stackMap = new int[boxes.size()];
        return createStack2(boxes, null, 0, stackMap);
    }

    int createStack2(List<Box> boxes, @Nullable Box bottom, int offset, int[] stackMap) {
        if (offset >= boxes.size()) {
            return 0;
        }

        final Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (stackMap[offset] == 0) {
                stackMap[offset] = createStack2(boxes, newBottom, offset + 1, stackMap);
                stackMap[offset] += newBottom.height;
            }
            heightWithBottom = stackMap[offset];
        }

        final int heightWithoutBottom = createStack2(boxes, bottom, offset + 1, stackMap);

        return Math.max(heightWithBottom, heightWithoutBottom);
    }
}
