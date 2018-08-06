package liubo.jzOffer.f01_StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueImplStack {
    Queue<Integer>queue1 = new LinkedList<Integer>();
    Queue<Integer>queue2 = new LinkedList<Integer>();
    public void push(int element){
        if (queue1.isEmpty()&&queue2.isEmpty()){
            queue1.add(element);
            return ;
        }
        if (queue1.isEmpty()){
            queue2.add(element);
            return;
        }
        if (queue2.isEmpty()){
            queue1.add(element);
            return;
        }
    }
    public int pop(){
        //如果两个栈都为空，则没有元素可以弹出，异常
        if (queue1.isEmpty()&&queue2.isEmpty()){
            try{
                throw new Exception("Stack is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //如果queue1中没有元素，queue2中有元素，将其queue2中的元素依次放入queue1中，直到最后一个元素，弹出即可
        if (queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        //如果queue2中没有元素，queue1中有元素，将其queue1中的元素依次放入queue2中，直到最后一个元素，弹出即可
        if (queue2.isEmpty()){
            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        TwoQueueImplStack qs = new TwoQueueImplStack();
        qs.push(2);
        qs.push(4);
        qs.push(7);
        qs.push(5);
        System.out.println(qs.pop());
        System.out.println(qs.pop());

        qs.push(1);
        System.out.println(qs.pop());
    }
}
