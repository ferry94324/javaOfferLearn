package liubo.struct.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode<Integer> t = new TreeNode<Integer>(1);
        t.addLeft(2);
        t.addRight(3);
        t.leftChild.addLeft(4);
        t.leftChild.addRight(5);
        System.out.println("中序遍历测试:");
        TreeTool.midOrderTravel(t);
        System.out.println("\n前序遍历测试:");
        TreeTool.preOrderTravel(t);
        System.out.println("\n后序遍历测试:");
        TreeTool.backOrderTravel(t);
        System.out.println("\n层次遍历测试:");
        TreeTool.levelTravel(t);
        System.out.println("\n树的深度:"+TreeTool.getTreeDepth(t));
        System.out.println("树的叶子个数:"+TreeTool.getLeafNum(t));
        System.out.println("树的节点个数:"+TreeTool.getTreeNum(t));
        System.out.println("第2层节点个数为:"+TreeTool.getNumForKlevel(t,2));
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        pre.add(2);
        pre.add(4);
        pre.add(5);
        pre.add(3);
        List<Integer> mid = new ArrayList<Integer>();
        mid.add(4);
        mid.add(2);
        mid.add(5);
        mid.add(1);
        mid.add(3);
        TreeNode<Integer> root = TreeTool.getTreeFromPreAndMid(pre, mid);
        System.out.println("\n通过前序和中序构建树测试：");
        TreeTool.levelTravel(root);
        System.out.println("\n构建的树比较测试:");
        System.out.println(TreeTool.equals(t,root));
    }
}
