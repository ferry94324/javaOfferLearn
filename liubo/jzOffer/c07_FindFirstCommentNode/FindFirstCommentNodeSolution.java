package liubo.jzOffer.c07_FindFirstCommentNode;
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class FindFirstCommentNodeSolution {
    public int getListLenght(ListNode node){
        int length = 0;
        while(node!=null){
            length++;
            node = node.next;
        }
        return length;
    }
    public ListNode FindFirstCommentNode(ListNode head1,ListNode head2){
        int head1Length = getListLenght(head1);
        int head2Length = getListLenght(head2);
        int difLength = head1Length-head2Length;
        ListNode longListNode = head1;
        ListNode shortListNode= head2;
        if (head1Length<head2Length){
            longListNode = head2;
            shortListNode= head1;
            difLength = head2Length-head1Length;
        }
        for (int i =0;i<difLength;i++){
            longListNode = longListNode.next;
        }
        while((longListNode!=null)&&(shortListNode!=null)&&(longListNode!=shortListNode)){
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }
        ListNode pFirstCommentNode = longListNode;
        return pFirstCommentNode;
    }
}
