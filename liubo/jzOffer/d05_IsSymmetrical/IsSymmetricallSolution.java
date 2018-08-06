package liubo.jzOffer.d05_IsSymmetrical;
class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val){
        this.val = val;
    }
}
public class IsSymmetricallSolution {
    public boolean isSymmeritical(TreeNode pRoot){
        return isSymmeritical(pRoot,pRoot);
    }
    public boolean isSymmeritical(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSymmeritical(root1.left,root2.right)&&isSymmeritical(root1.right,root2.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        IsSymmetricallSolution isSymmetricallSolution = new IsSymmetricallSolution();
        boolean flag = isSymmetricallSolution.isSymmeritical(node1);
        System.out.println(flag);
    }
}
