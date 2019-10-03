package Queue;

/**
 * @ClassName Queue
 * @Author sensu
 * @Date 2019/10/3 15:52
 **/
public interface Queue<E> {
    /**
     * 返回队列大小
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队操作
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     *
     * @return
     */
    E dequeue();

    /**
     * 查看队列头部的元素
     *
     * @return
     */
    E getFront();

}
