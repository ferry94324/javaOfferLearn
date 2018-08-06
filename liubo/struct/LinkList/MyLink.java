package liubo.struct.LinkList;

public class MyLink {
    Node head = null;
    class Node{
        Node next = null;
        int data;
        public Node(int data){
            this.data = data;
        }
    }
    /**
     * 链表中插入数据,在末尾处添加
     */
    public void addNode(int d){
        Node newnode = new Node(d);
        if (head==null){
            head = newnode;
            return;
        }
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newnode;
    }

    /**
     * 删除第index个节点
     * @param index
     * @return
     */
    public boolean deleteNode(int index){
        if (index<1||index>length()){
            return false;
        }
        if(index==1){
            return true;
        }
        int i =1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode!=null){
            if(i==index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     * 不知道头节点情况下删除指定节点
     * @param n
     * @return
     */
    public boolean deleteNode1(Node n){
        if(n==null||n.next==null){
            return false;
        }
        int temp = n.data;
        n.data = n.next.data;
        n.next.data = temp;
        n.next = n.next.next;
        return true;
    }
    /**
     * 返回链表长度
     * @return
     */
    public int length(){

        int length =0;
        Node temp = head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    /**
     * 打印链表
     */
    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void printList2(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    /**
     * 反转链表
     * @return
     */
    public Node ReverseIteratively() {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
        return this.head;
    }

    /**
     * 寻找链表的中间值
     * 采用快慢指针的方式查找单链表的中间节点，快指针一次走两步，慢指针一次走一步，当快指针走完时，慢指针刚好到达中间节点。
     * @return
     */
    public Node searchMid(){
        Node p = head;
        Node q = head;
        while(p!=null&&p.next!=null&&p.next.next!=null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    /**
     * 采用两个指针P1,P2，P1先前移K步，然后P1、P2同时移动，当p1移动到尾部时，P2所指位置的元素即倒数第k个元素
     * @param k
     * @return
     */
    public Node findElem(int k){
        if(k<1||k>this.length()){
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for(int i =0;i<k;i++){
            p1 = p1.next;
        }
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     *对链表排序
     * @return
     */
    public Node orderList(){
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while(curNode!=null){
          nextNode = curNode.next;
          while (nextNode!=null){
              if (curNode.data>nextNode.data){
                  temp = curNode.data;
                  curNode.data = nextNode.data;
                  nextNode.data= temp;
              }
              nextNode = nextNode.next;
          }
          curNode = curNode.next;
        }
        return head;
    }

    /**
     * 删除重复节点
     */
    public void deleteDuplecate() {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (p.data == q.next.data) {
                    q.next = q.next.next;
                } else
                    q = q.next;
            }
            p = p.next;
        }

    }

    /**
     * 递归逆序输出
     * @param pListhead
     */
    public void printListReversely(Node pListhead){
        if(pListhead!=null){
            printListReversely(pListhead.next);
            System.out.println(pListhead.data);
        }
    }
    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();
        System.out.println("递归逆序输出：");
        list.printListReversely(list.head);
        System.out.println("反转输出：");
        list.ReverseIteratively();
        list.printList();
        Node mid =list.searchMid();
        System.out.println("Mid:"+mid.data);
        Node kNode = list.findElem(2);
        System.out.println("KNode:"+kNode.data);
        Node newhead = list.orderList();
        list.printList2(newhead);

    }
}
