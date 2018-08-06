package liubo.jzOffer.c01_linkListTailToHead;

import java.util.ArrayList;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class PrintListTailToHeadSolution {
    ArrayList<Integer> arraylist = new ArrayList<Integer>();
    public ArrayList<Integer> printListfromTailToHead(ListNode listNode){
        if(listNode!=null){
            printListfromTailToHead(listNode.next);
            arraylist.add(listNode.val);
        }
        return arraylist;
    }
    public ArrayList<Integer> printListfromTailToHead2(ListNode listNode){
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            arraylist.add(stack.pop());
        }
        return arraylist;
    }

    public static void main(String[] args) {
        PrintListTailToHeadSolution plt  = new PrintListTailToHeadSolution();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ArrayList<Integer> arraylist1 = new ArrayList<Integer>();
        ArrayList<Integer> arraylist2 = new ArrayList<Integer>();
        arraylist1 = plt.printListfromTailToHead(node1);
        arraylist2 = plt.printListfromTailToHead2(node1);
        System.out.println(arraylist1);
        System.out.println(arraylist2);
    }
}
