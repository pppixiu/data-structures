package Map;

/**
 * @ClassName Map
 * @Author sensu
 * @Date 2019/10/7 22:46
 **/
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
