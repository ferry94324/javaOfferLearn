package liubo.jzOffer.d02_GetBinaryTreeNodeNext;
class TreeLinkNode{
    String val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    TreeLinkNode(String val){
        this.val = val;
    }
}
public class GetBinaryTreeNodeNextSolution {
    public TreeLinkNode getBinaryNodeNext(TreeLinkNode pNode){
        if (pNode==null){
            return null;
        }
        if (pNode.right!= null){
            pNode =pNode.right;
            while(pNode.left!= null){
                pNode =pNode.left;
            }
            return pNode;
        }
        while(pNode.next!=null){
            if(pNode.next.left==pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode("a");
        TreeLinkNode node2 = new TreeLinkNode("b");
        TreeLinkNode node3 = new TreeLinkNode("c");
        TreeLinkNode node4 = new TreeLinkNode("d");
        TreeLinkNode node5 = new TreeLinkNode("e");
        TreeLinkNode node6 = new TreeLinkNode("f");
        TreeLinkNode node7 = new TreeLinkNode("g");
        TreeLinkNode node8 = new TreeLinkNode("h");
        TreeLinkNode node9 = new TreeLinkNode("i");
        node1.left = node2;node1.right = node3;
        node2.left = node4;node2.right = node5;
        node3.left = node6;node3.right = node7;
        node5.left = node8;node5.right = node9;
        node8.next = node5;node9.next = node5;
        node4.next = node2;node5.next = node2;
        node6.next = node3;node7.next = node3;
        node2.next = node1;node3.next = node1;
        GetBinaryTreeNodeNextSolution gbtns = new GetBinaryTreeNodeNextSolution();
        TreeLinkNode pNode = gbtns.getBinaryNodeNext(node5);
        System.out.println("node5:"+node5.val+" "+"node5.next:"+pNode.val);


    }
}
