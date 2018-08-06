package liubo.jzOffer.c04_FindKthToTail;
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class FindKthToTailSolution {
    public ListNode FindKthToTail(ListNode pHead ,int k){
        if (k<1||pHead==null){
            return null;
        }
        ListNode ANode = pHead;
        ListNode BNode = pHead;
        for (int i =0;i<k;i++){
            if (ANode!=null){
                ANode = ANode.next;
            }else{
                return null;
            }
        }
        while(ANode!=null){
            ANode = ANode.next;
            BNode = BNode.next;
        }
        return BNode;
    }

    public static void main(String[] args) {
        FindKthToTailSolution fkts = new FindKthToTailSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode Knode = fkts.FindKthToTail(node1,1);
        System.out.println("第k个数是："+Knode.val);
    }
}
