package liubo.jzOffer.c03_deleteRepeatNode;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class deleteDuplicationSoultion {
    // 递归实现
    public ListNode deleteDuplication_1(ListNode pHead) {
        // 递归停止条件
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode current = pHead.next;
        // 如果pHead是重复元素
        if (pHead.val == current.val) {
            current = current.next;
            while (current != null && current.val == pHead.val)
                current = current.next;
            pHead = current;
            return deleteDuplication_1(current);
        } else {
            // pHead不是重复元素
            pHead.next = deleteDuplication_1(current);
            return pHead;
        }
    }
    //方法二：循环实现
    public ListNode deleteDuplication_2(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode preNode = null;
        ListNode node = pHead;
        ListNode postNode = null;
        boolean needDel = false;

        while (node != null) {
            // 如果node不是最后一个节点
            if (node.next != null) {
                postNode = node.next;
                //postNode为null或者val与node.val不同的第一个节点
                while (postNode != null && postNode.val == node.val) {
                    postNode = postNode.next;
                    needDel = true;
                }
            } else
                //到链表结尾
                postNode = null;
            // 如果node和postNode不同，即不需要进行删除操作
            if (!needDel) {
                //如果第一个元素为空
                if (preNode == null) {
                    preNode = node;
                    pHead = preNode;
                } else {
                    preNode.next = node;
                    preNode = node;
                }
                node = postNode;
            } else {
                node = postNode;
                needDel = false;
                if (postNode == null && preNode != null)
                    preNode.next = null;
            }
        }
        return preNode == null ? null : pHead;
    }


    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode pPreNode=null;
        ListNode pNode=pHead;
        while(pNode!=null){
            ListNode pNext=pNode.next;
            boolean needDelete=false;
            if(pNext!=null&&pNext.val==pNode.val)
                needDelete=true;
            if(!needDelete){
                pPreNode=pNode;
                pNode=pNode.next;
            }else{
                int value=pNode.val;
                ListNode pToBeDel=pNode;
                while(pToBeDel!=null&&pToBeDel.val==value){
                    pNext=pToBeDel.next;
                    pToBeDel=pNext;
                }
                if(pPreNode==null)
                    pHead=pNext;
                else
                    pPreNode.next=pNext;
                pNode=pNext;
            }
        }
        return pHead;

    }

    public static void main(String[] args) {
        deleteDuplicationSoultion ddcs = new deleteDuplicationSoultion();
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
        ListNode node7 =ddcs.deleteDuplication(node1);
        while(node7!=null){
            System.out.println(node7.val);
            node7 = node7.next;
        }
    }
}
