package UnionFind;

/**
 * quick union 基于size优化
 *
 * @ClassName UnionFind3
 * @Author sensu
 * @Date 2019/10/12 20:25
 **/
public class UnionFind3 implements UF {
    private int[] parent;
    private int[] sz;   // sz[i] 表示以i为根的集合中元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * 查找p所对应的集合编号
     * O（h）复杂度  h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p]) {
            p = parent[p];
        }

        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否所属同一个集合
     * O（h）复杂度  h为书的高度
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p 跟 元素q所属的集合
     * O（h）复杂度  h为树的高度
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        //通过判断节点的子元素个数 判断如何合并
        //之后要修改sz[root]的大小
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
