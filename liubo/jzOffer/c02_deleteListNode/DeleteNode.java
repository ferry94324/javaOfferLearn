package liubo.jzOffer.c02_deleteListNode;
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class DeleteNode {
    public void deleteNode(ListNode head,ListNode deleteNode){
        if (deleteNode==null||head == null){
            return ;
        }
        if (head == deleteNode){
            head = null;
        }else{
            if (deleteNode.next==null){
                ListNode pintListNode = head;
                while(pintListNode.next.next!=null){
                    pintListNode = pintListNode.next;
                }
                pintListNode.next = null;
            }else{
                deleteNode.val = deleteNode.next.val;
                deleteNode.next = deleteNode.next.next;

            }
        }
    }
    public void printList2(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        DeleteNode dn = new DeleteNode();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        dn.printList2(node1);
        dn.deleteNode(node1,node4);
        System.out.println("under delete LinkList:");
        dn.printList2(node1);
    }
}
