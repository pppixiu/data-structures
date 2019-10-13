package UnionFind;

/**
 * @ClassName UF
 * @Author sensu
 * @Date 2019/10/12 16:59
 **/
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
