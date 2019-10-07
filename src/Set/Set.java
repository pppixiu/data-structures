package Set;

/**
 * @ClassName Set
 * @Author sensu
 * @Date 2019/10/6 17:53
 **/
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
