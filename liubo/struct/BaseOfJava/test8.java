package liubo.struct.BaseOfJava;

import java.util.Scanner;

public class test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 8;
        int h = 0;
        if (k%4!=0){
            h = k/4+1;
        }else{
            h = k/4;
        }
        int hh = (int)Math.ceil(Math.log(h)/Math.log(2));
        int least = k -4* ((int)Math.pow(2,hh-1)-1);
        System.out.println(((int)Math.pow(2,hh)));
        int m = least/((int)Math.pow(2,hh-1));
        String [] name = {"Alice","Bob","Cathy","Dave"};
        System.out.println(name[m]);
    }
}
