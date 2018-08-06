package liubo.jzOffer.d08_FindTreePath;

import java.util.ArrayList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class FindTreePathSolution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        FindTreePathSolution findTreePathSolution = new FindTreePathSolution();
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        pathList = findTreePathSolution.FindPath(node1,22);
        System.out.println(pathList);
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if (root == null||root.val>target)
            return pathList;
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPath(root,target,pathList,path);
        return pathList;
    }
    public void findPath(TreeNode root,int target,ArrayList<ArrayList<Integer>> pathList,ArrayList<Integer> path){
        if (root==null||root.val>target){
            path.clear();
        }
        else if (root.val == target){
            if (root.left == null&&root.right == null){
                path.add(root.val);
                pathList.add(path);
            }else{
                path.clear();
            }
        }else{
            path.add(root.val);
            ArrayList<Integer> path2 = new ArrayList<Integer>();
            path2.addAll(path);
            target-=root.val;
            findPath(root.left,target,pathList,path);
            findPath(root.right,target,pathList,path2);
        }
    }
}
