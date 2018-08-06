package liubo.jzOffer.d01_RebuiltBinaryTreeFromPreAndMid;

import java.util.LinkedList;
import java.util.Queue;

public class RebuiltBinaryTreeFromPreAndMidSolution2 {
   public static TreeNode Constract(int pre[],int in[],int length){
       if(pre ==null||in == null||length<1){
           return null;
       }

       return constractCore(pre,in,0,length-1,0,length-1);
   }
   public static TreeNode constractCore(int pre[],int in[],int startPre,int endPre ,int startIn,int endIn){
       int rootValue = pre[startPre];
       TreeNode root = new TreeNode(rootValue);
       root.left = null;
       root.right = null;
       if (startPre == endPre){
           if (startIn == endIn&&startPre ==endPre ){
               System.out.println("root");
               return root;
           }
       }
       int rootIn = startIn;
       while(rootIn<=endIn&&in[rootIn]!=rootValue){
           ++rootIn;
       }
       if (rootIn==endIn&&in[rootIn]!=rootValue){
           System.out.println("invalid input");
       }
       int leftLength = rootIn-startIn;
       int leftPreEnd = startPre+leftLength;
       if (leftLength>0){
           root.left = constractCore(pre,in,startPre+1,leftPreEnd,startIn,rootIn-1);
       }
       if (leftLength<endPre-startPre){
           root.right = constractCore(pre,in,leftPreEnd+1,endPre,rootIn+1,endIn);
       }
       return root;
   }
   public static void preorderTravelVal(TreeNode root){
       if (root==null){
           return;
       }
       System.out.print(root.val+" ");
       preorderTravelVal(root.left);
       preorderTravelVal(root.right);
   }
    public static void visitNode(TreeNode node) {
        System.out.print(node.val + " ");
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
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};
        levelTravel(Constract(pre,in,8));
    }
}
