package liubo.struct.Tree;

public class TreeNode<T> {
    T value;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;
    TreeNode(T value){
        this.value = value;
    }

    /**
     * 构造函数
     */
    TreeNode(){
    }

    /**
     * 增加左子节点
     * @param value
     */
    public void addLeft(T value){
        TreeNode<T> leftChild = new TreeNode<T>(value);
        this.leftChild = leftChild;
    }

    /**
     * 增加右子节点
     * @param value
     */
    public void addRight(T value){
        TreeNode<T> rightChild = new TreeNode<T>(value);
        this.rightChild = rightChild;
    }

    /**
     * 重载equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  TreeNode)){
            return false;
        }
        return this.value.equals(((TreeNode<?>)obj).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return this.value==null?"":this.value.toString();
    }
}
