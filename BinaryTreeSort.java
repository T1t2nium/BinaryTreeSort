package TreeStudy;

/**
 * 基于二叉树结构实现元素排序处理的排序器
 * @param <E>
 */
public class BinaryTreeSort<E extends Integer> {
    /**
     * 节点类
     * @param <E>
     */
    class Node<E extends Integer>{
        private E item;//存放元素
        private Node left;//存放左子树的地址
        private Node rignt;//存放右子树的地址

        public Node(E item) {
            this.item = item;
        }

        /**
         * 添加节点
         * @param node
         */
        public void add(Node node){
            //判断元素大小
            //左子树
            if(node.item.intValue()<this.item.intValue()){
                if(this.left==null){
                    this.left = node;
                }else {
                    this.left.add(node);
                }
            }
            //右子树
            else {
                if(this.rignt==null){
                    this.rignt = node;
                }else {
                    this.rignt.add(node);
                }
            }
        }
        /**
         * 中序遍历二叉树
         */
        public void inorderTraversal(){
            //找到最左侧的节点
            if(this.left!=null) this.left.inorderTraversal();
            System.out.println(this.item);
            if (this.rignt!=null) this.rignt.inorderTraversal();
        }
    }
    //根节点
    private Node root =null;

    /**
     * 添加元素
     * @param element
     */
    public void add(E element){
        //实例化节点对象
        Node<E> node = new Node<>(element);
        //判断二叉树是否为空
        if(this.root == null){
            this.root = node;
        }else
        {
            this.root.add(node);
        }
    }

    /**
     * 将元素排序
     */
    public void sort(){
        //判断二叉树是否为空
        if(this.root ==null)
            return;
            this.root.inorderTraversal();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        BinaryTreeSort<Integer> sort= new BinaryTreeSort<>();
        //1,8,6,3,5,2
        sort.add(1);
        sort.add(8);
        sort.add(6);
        sort.add(3);
        sort.add(5);
        sort.add(2);
        sort.sort();
    }
}
