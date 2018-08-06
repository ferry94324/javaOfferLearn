package liubo.jzOffer.d03_HasSubTree;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class HasSubTreeSolution {
    public boolean DoseTree1HasTree2(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if (root1==null){
            return false;
        }
        if (root1.val!=root2.val){
            return false;
        }
        return DoseTree1HasTree2(root1.left,root2.left)&&DoseTree1HasTree2(root1.right,root2.right);
    }
    public boolean HasSubTree(TreeNode root1,TreeNode root2){
        boolean result = false;
        if (root1!= null&&root2!=null){
            if (root1.val==root2.val){
                result = DoseTree1HasTree2(root1,root2);
            }
            if (!result){
                result = HasSubTree(root1.left,root2);
            }
            if (!result){
                result = HasSubTree(root1.right,root2);
            }
        }
        return result;
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
        node5.left = node6;
        node5.right = node7;
        TreeNode node11 = new TreeNode(8);
        TreeNode node22 = new TreeNode(9);
        TreeNode node33 = new TreeNode(2);
        node11.left = node22;
        node11.right = node33;
        HasSubTreeSolution hts = new HasSubTreeSolution();

        System.out.println(hts.HasSubTree(node1,node11));
    }
}
