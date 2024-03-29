package Trie;

import java.nio.channels.NetworkChannel;
import java.util.TreeMap;

/**
 * @ClassName Trie
 * @Author sensu
 * @Date 2019/10/11 19:24
 **/
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得Trie中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word 非递归
     *
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        //一层一层向下遍历直到整个单词都添加进Trie中
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        //遍历之后将isword设置为true
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 向Trie中添加新的单词word  递归
     *
     * @param word
     */
    public void addRecur(String word) {
        addRecur(root, word);
    }

    /**
     * 向Trie中添加一个新的单词word  递归
     */
    private void addRecur(Node node, String word) {
        if ("".equals(word)) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }

        char c = word.charAt(0);
        if (node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        addRecur(node.next.get(c), word.substring(1));
    }

    /**
     * 查询单词word是否在Trie中
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 在Trie 中查找是否有单词以prefix为前缀
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
