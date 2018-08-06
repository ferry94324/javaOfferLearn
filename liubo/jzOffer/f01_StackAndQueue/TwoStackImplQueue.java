package liubo.jzOffer.f01_StackAndQueue;

import java.util.Stack;

public class TwoStackImplQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int element){
        stack1.push(element);
    }
    public int pop(){
        if (stack1.isEmpty()&&stack2.isEmpty()){
            try{
                throw  new Exception("Stack is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackImplQueue sq = new TwoStackImplQueue();
        sq.push(1);
        sq.push(3);
        sq.push(5);
        sq.push(4);
        sq.push(2);

        System.out.println(sq.pop());
        System.out.println(sq.pop());

        sq.push(7);
        System.out.println(sq.pop());
    }
}
