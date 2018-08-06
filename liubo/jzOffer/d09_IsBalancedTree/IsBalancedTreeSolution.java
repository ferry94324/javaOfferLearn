package liubo.jzOffer.d09_IsBalancedTree;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class IsBalancedTreeSolution {
    public boolean IsBalancedTree(TreeNode root,int depth){
        if (root == null){
            depth = 0;
            return true;
        }
        int left = 0;
        int right = 0;
        if (IsBalancedTree(root.left,left)&&IsBalancedTree(root.right,right)){
            int diff = left-right;
            if (diff<=1&&diff>=-1){
                depth = 1+(left>right?left:right);
                return true;
            }
        }
        return false ;
    }
    public boolean IsBalancedTree(TreeNode root){
        int depth = 0;
        return IsBalancedTree(root,depth);
    }
    public boolean IsBalancedTree2(TreeNode root){
        if (root == null){
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left-right)>1){
            return false;
        }
        return true;
    }
    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return (left>right)?(left+1):(right+1);
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.right = node6;
        node5.left = node7;
        node7.right = node6;
        IsBalancedTreeSolution isBalancedTreeSolution = new IsBalancedTreeSolution();
        boolean flag = isBalancedTreeSolution.IsBalancedTree2(node1);
        System.out.println(flag);
    }
}
