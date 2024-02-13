package tree;

public class BinarySearchTree {

    private Node tree;


    /**
     * 二分搜索树的查找
     * @param data
     * @return
     */
    public Node find(int data){
        Node p = tree;
        while (p != null){
            if (p.data == data) {
                return p;
            } else if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 二分搜索树的插入
     * @param data
     */
    public void insert(int data){
        if (tree == null) {
            tree = new Node(data);
        }
        Node p = tree;
        while (true) {
            if (p.data > data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                } else {
                    p = p.right;
                }
            }
        }
    }

    /**
     * 二叉搜索树的删除
     */
    public void delete(int data){
        if (tree == null) {
            return;
        }
        Node p = tree; // 指向要删除的节点，初始化为根节点
        Node pp = null; // 指向p的父节点
        // 1.找到要删除的节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return;
        // 2.要删除的节点下有两个子节点
        if (p.left != null && p.right != null) {
            // 找到右侧最小节点
            Node minP = p.right;
            Node minPP = p; // 最小节点的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 最小节点的值作为删除节点的值
            p.data = minP.data;
            // 更新待删除节点为最小节点，待删除节点的父节点为最小节点的父节点
            // 这样在后面的代码中，我们就可以把p看作是要删除的节点，pp是它的父节点
            pp = minPP;
            p = minP;
        }

        // 3.要删除的节点下只有一个子节点或者是叶子节点
        Node child;
        if (p.left != null) child=p.left;
        else if (p.right != null) child = p.right;
        else child = null;
        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;

    }


    /**
     * 查找最小节点
     * @return
     */
    public Node findMin(){
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * 查找最大节点
     * @return
     */
    public Node findMax(){
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null){
            p = p.right;
        }
        return p;
    }






    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
