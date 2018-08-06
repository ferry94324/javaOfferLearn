package liubo.jzOffer.d06_PrintTree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintTreeWithZhiSolution {
    public ArrayList<ArrayList<Integer>> PrintTreeWithZhi(TreeNode root){
        int leval = 1;
        //存奇数层节点
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        stack1.push(root);
        //存偶数层节点
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            if(leval%2==0){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    if (node!=null){
                        temp.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }
                    if (!temp.isEmpty()){
                        list.add(temp);
                        leval++;
                    }
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    if (node!=null){
                        temp.add(node.val);
                        stack1.push(node.left);
                        stack1.push(node.right);
                    }
                    if (!temp.isEmpty()){
                        list.add(temp);
                        leval++;
                    }
                }
            }
        }
        return list;
    }

}
