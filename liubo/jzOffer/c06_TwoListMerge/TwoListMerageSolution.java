package liubo.jzOffer.c06_TwoListMerge;

class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class TwoListMerageSolution {
    public ListNode ListMerage(ListNode pHead1,ListNode pHead2){
        if (pHead1 == null){
            return pHead2;
        }
        if (pHead2 == null){
            return pHead1;
        }
        ListNode pMeragedNode = null;
        if (pHead1.val<pHead2.val){
            pMeragedNode = pHead1;
            pMeragedNode.next = ListMerage(pHead1.next,pHead2);
        }else{
            pMeragedNode = pHead2;
            pMeragedNode.next = ListMerage(pHead1,pHead2.next);
        }
        return pMeragedNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        TwoListMerageSolution tlms = new TwoListMerageSolution();
        ListNode pMeragedNode = tlms.ListMerage(node1,node5);
        while(pMeragedNode!=null){
            System.out.print(pMeragedNode.val);
            pMeragedNode =pMeragedNode.next;
        }
    }
}
