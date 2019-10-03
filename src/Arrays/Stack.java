package Arrays;

public interface Stack<E> {

    /**
     * 获取栈大小
     *
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     *
     * @return
     */
    boolean isEmpt();

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈 返回栈顶元素
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

}
