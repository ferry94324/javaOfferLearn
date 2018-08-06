package liubo.struct.BaseOfJava;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
//        String str = "";
//
//        @SuppressWarnings("resource")
//        Scanner scan = new Scanner(System.in);
//
//        str = scan.nextLine();
        char aa[] = {'a','b','c'};
        permutation(aa, 0);
    }

    public static void permutation(char[] str, int i) {
        if (i >= str.length)
            return;
        if (i == str.length - 1) {
            System.out.println("out"+String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                System.out.println("--------");
                System.out.println("str"+i+String.valueOf(str));
                System.out.println("========");

                permutation(str, i + 1);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                System.out.println("++++++++");
                System.out.println("str"+i+String.valueOf(str));
                System.out.println("*********");
            }
        }
    }

}
