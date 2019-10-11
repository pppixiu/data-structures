package SegmentTree;

/**
 * @ClassName Merger
 * @Author sensu
 * @Date 2019/10/10 14:25
 **/
public interface Merger<E> {
    E merge(E a, E b);
}
