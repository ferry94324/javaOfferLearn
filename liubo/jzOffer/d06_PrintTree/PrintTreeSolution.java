package liubo.jzOffer.d06_PrintTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val){
        this.val = val;
    }
}
public class PrintTreeSolution {
     public void PrintTreeTopToBottom(TreeNode root){
         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
             TreeNode tmp = q.poll();
             System.out.println(tmp.val);
             if (tmp.left!=null){
                 q.offer(tmp.left);
             }
             if (tmp.right!=null){
                 q.offer(tmp.right);
             }
         }
     }
     public void PrintTreeInEachLevel(TreeNode root){
         if (root==null){
             return;
         }
         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);
         //nextLevel表示的是下一层有多少个点，toBePrint表示当前未打印的点
         int nextLevel = 0;
         int toBePrint = 1;
         while(!q.isEmpty()){
             TreeNode tmp = q.poll();
             System.out.print(tmp.val+" ");
             if (tmp.left!=null){
                 q.offer(tmp.left);
                 nextLevel++;
             }
             if (tmp.right !=null){
                 q.offer(tmp.right);
                 nextLevel++;
             }
             toBePrint--;
             //当当前的点都打印完成后，打印下一级的点这时候未打印的点就是下一级有多少个点，然后将下一级节点归为0
             if (toBePrint==0){
                 System.out.println();
                 toBePrint = nextLevel;
                 nextLevel = 0;
             }
         }
     }
    public ArrayList<ArrayList<Integer>> PrintTreeWithZhi(TreeNode root){
        int leval = 1;
        //存奇数层节点
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        stack1.push(root);
        //存偶数层节点
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while(!stack1.empty()||!stack2.empty()){

            if(leval%2!=0){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!stack1.empty()){
                    TreeNode node = stack1.pop();
                    if (node!=null){
                        temp.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }

                }
                if (!temp.isEmpty()){
                    list.add(temp);
                    leval++;
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!stack2.empty()){
                    TreeNode node = stack2.pop();
                    if (node!=null){
                        temp.add(node.val);
                        stack1.push(node.right);
                        stack1.push(node.left);
                    }

                }
                if (!temp.isEmpty()){
                    list.add(temp);
                    leval++;
                }
            }
        }
        return list;
    }
    public ArrayList<ArrayList<Integer>> PrintTreeWithZhi2(TreeNode root){
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(root);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while (!s1.empty() || !s2.empty()) {
            if (layer%2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
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
        PrintTreeSolution printTreeSolution = new PrintTreeSolution();
        printTreeSolution.PrintTreeInEachLevel(node1);
//        printTreeSolution.PrintTreeTopToBottom(node1);
        ArrayList<ArrayList<Integer>> list = printTreeSolution.PrintTreeWithZhi(node1);
        System.out.println(list.size());

    }
}
