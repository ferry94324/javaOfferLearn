package liubo.jzOffer.d04_MirrorTree;
class TreeNode{
    int val;
    TreeNode left =null;
    TreeNode right = null;
    TreeNode(int val){
        this.val = val;
    }
}
public class MirrorTreeSolution {
    public  void preorderTravelVal(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorderTravelVal(root.left);
        preorderTravelVal(root.right);
    }
    public void Mirror(TreeNode root){
        if (root==null){
            return  ;
        }
        if(root.right==null&&root.left==null){
            return  ;
        }
        TreeNode ptmp = root.left;
        root.left = root.right;
        root.right = ptmp;
        if (root.left!=null){
            Mirror(root.left);
        }
        if (root.right!=null){
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        MirrorTreeSolution mts = new MirrorTreeSolution();
        mts.preorderTravelVal(node1);
        mts.Mirror(node1);
        System.out.println("");
        mts.preorderTravelVal(node1);
    }
}
