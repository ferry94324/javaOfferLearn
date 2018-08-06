package liubo.struct.BaseOfJava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class test5 {
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);

        int n=scan.nextInt();
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<n;i++)
        {
            int k=scan.nextInt();
            if(!queue.contains(k))
            {
                queue.add(k);
            }
        }
        if(queue.size()<=10)
        {
            System.out.println(queue.size());
            for(int id:queue)
            {
                System.out.println(id);
            }
        }
        else
        {
            System.out.println(10);
            for(int m=0;m<10;m++)
            {

                System.out.println(queue.poll());
            }
        }
    }
}

