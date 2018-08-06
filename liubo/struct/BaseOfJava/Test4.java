package liubo.struct.BaseOfJava;
class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val)
    {
        this.val = val;
    }
}

public class Test4 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        int TreeDepth = GetTreeDepth(root);
        System.out.println("深度是  ：" + TreeDepth);
    }
    private static int GetTreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = GetTreeDepth(root.left);
//        System.out.println("left  :"+left);
//        System.out.println("+++++++++");
        int right = GetTreeDepth(root.right);
//        System.out.println("---------");
//        System.out.println("right  :"+right);
        return (left > right)?(left+1):(right+1);
    }


}
