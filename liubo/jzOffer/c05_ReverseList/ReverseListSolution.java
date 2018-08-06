package liubo.jzOffer.c05_ReverseList;

class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class ReverseListSolution {
    public ListNode ReverseList(ListNode pHead){
        ListNode pReverse = null;
        ListNode pNode = pHead;
        ListNode pPrev = null;
        while(pNode!=null){
            ListNode pNext = pNode.next;
            if (pNext==null){
                pReverse = pNode;
            }
            pNode.next = pPrev;

            pPrev = pNode;
            pNode = pNext;
        }
        return pReverse;
    }

    public static void main(String[] args) {
        ReverseListSolution rls = new ReverseListSolution();
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
        ListNode node7 = rls.ReverseList(node1);
        while(node7!=null){
            System.out.println(node7.val);
            node7 = node7.next;
        }
    }
}
