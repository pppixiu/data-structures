package MaxHeap;

import Arrays.Array;

import java.util.Random;

/**
 * @ClassName MaxHeap
 * @Author sensu
 * @Date 2019/10/8 21:40
 **/
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    /**
     * 传入数组生成MaxHeap
     * heapify操作 传入的数组一定是完全二叉树  从最后一个非叶子节点开始执行siftDown操作即可
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    /**
     * 返回堆中元素的个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回布尔值，表示堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 堆元素的上浮
     *
     * @param k
     */
    private void siftUp(int k) {
        //当k大于0并且其父亲节点的元素比当前元素的值小的时候 执行whileu循环
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            //交换该节点与其父节点
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 从堆中取出最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    /**
     * 对节点k进行下浮操作
     *
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            //得到左孩子的索引
            int j = leftChild(k);
            //假如右孩子存在并且右孩子的值大于左孩子的值 则将j更新为右孩子的索引
            if (rightChild(k) < data.getSize() &&
                    data.get(rightChild(k)).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            //当前节点的值比 较大的子节点 大或者相等的时候 结束循环
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(j, k);
            k = j;
        }
    }

    /**
     * 取出堆中最大的元素 并且替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * 查看堆中的最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        }
        return data.get(0);
    }
}
