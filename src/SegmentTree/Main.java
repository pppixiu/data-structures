package SegmentTree;

/**
 * @ClassName Main
 * @Author sensu
 * @Date 2019/10/10 14:45
 **/
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {2, 5, 6, 8, 9, 7, 4, 0};

        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, (a, b) -> a + b);

        System.out.println(segmentTree.query(0, 3));
    }
}
