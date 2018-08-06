package liubo.jzOffer.d01_RebuiltBinaryTreeFromPreAndMid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RebuiltBinaryTreeFromPreAndMidSolution {
    public static void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    public static TreeNode construct(int[] pre, int[] in, int length) {
        if (pre == null || in == null || length <= 0)
            return null;
        return constructCore(pre, in, 0, length - 1, 0, length - 1);

    }

    public static TreeNode constructCore(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
        int rootValue = pre[startPre];
        TreeNode root = new TreeNode(rootValue);
        root.left = null;
        root.right = null;
        if (startPre == endPre) {
            if (startIn == endIn && startPre == startIn) {
                System.out.println("root");
                return root;
            }
        }
        int rootIn = startIn;
        while (rootIn <= endIn && in[rootIn] != rootValue) {
            ++rootIn;
        }
        if (rootIn == endIn && in[rootIn] != rootValue) {
            System.out.println("Invalid input2");
        }
        int leftLength = rootIn - startIn;
        int leftPreEnd = startPre + leftLength;
        if (leftLength > 0) {
            root.left = constructCore(pre, in, startPre + 1, leftPreEnd, startIn, rootIn - 1);
        }
        if (leftLength < endPre - startPre) {
            root.right = constructCore(pre, in, leftPreEnd + 1, endPre, rootIn + 1, endIn);
        }
        return root;
    }

    public TreeNode rebuiltBinaryTreeFromPreAndMid(List<Integer> pre, List<Integer> mid) {
        if (pre == null || mid == null || pre.size() == 0 || mid.size() == 0) {
            return null;
        }
        if (pre.size() == 1) {
            return new TreeNode(pre.get(0));
        }
        TreeNode root = new TreeNode(pre.get(0));
        int index = 0;
        while (!mid.get(index++).equals(pre.get(0))) {

        }
        // 构建左子树的前序
        List<Integer> preLeft = new ArrayList<Integer>(index);
        // 左子树的中序
        List<Integer> midLeft = new ArrayList<Integer>(index);
        for (int i = 1; i < index; i++) {
            preLeft.add(pre.get(i));
        }
        for (int i = 0; i < index - 1; i++) {
            midLeft.add(mid.get(i));
        }

        root.left = rebuiltBinaryTreeFromPreAndMid(preLeft, midLeft);
        // 右子树的前序
        List<Integer> preRight = new ArrayList<Integer>(pre.size() - index - 1);
        // 右子树的中序
        List<Integer> midRight = new ArrayList<Integer>(pre.size() - index - 1);
        for (int i = 0; i <= pre.size() - index - 1; i++) {
            preRight.add(pre.get(index + i));
            midRight.add(mid.get(index + i));
        }

        root.right = rebuiltBinaryTreeFromPreAndMid(preRight, midRight);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public static void visitNode(TreeNode node) {
        System.out.println(node.val + "\t");
    }

    public static void levelTravel(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            visitNode(temp);
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
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
        int[] first = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] second = {4, 7, 2, 1, 5, 3, 8, 6};
        RebuiltBinaryTreeFromPreAndMidSolution rbts = new RebuiltBinaryTreeFromPreAndMidSolution();
        TreeNode root = rbts.rebuiltBinaryTreeFromPreAndMid(pre, mid);
        rbts.levelTravel(root);
        TreeNode root2 = rbts.reConstructBinaryTree(first, second);
        rbts.levelTravel(root2);
    }
}
