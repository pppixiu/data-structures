package UnionFind;

/**
 * quick union 基于rank优化 实现路径压缩(递归完成进一步的压缩 一次性让节点指向根节点)
 *
 * @ClassName UnionFind6
 * @Author sensu
 * @Date 2019/10/13 16:33
 **/
public class UnionFind6 implements UF {
    private int[] parent;
    private int[] rank;   // rank[i] 表示以i为根的集合所表示的树的排名

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        if (p != parent[p]) {
            //路径压缩
            //递归将指针指向根节点
            parent[p] = find(parent[p]);
        }

        return parent[p];
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

        //根据两个元素所在的树的rank不同判断合并方向
        //将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else { //rank[pRoot] == rank[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
