package liubo.interviewTest.pinduoduo;

import java.util.Scanner;

/**
 * 输出一个正方形，从上面开始从左到右输出，然后右边从上到下，然后下面从右到左
 *
 */
public class MatrixStringOutPut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int row = input.length()/4;
        int index = row+1;
        StringBuffer result = new StringBuffer();
        result.append(input.substring(0,index)+"\n");
        for (int i = 1;i<index-1;i++){
            result.append(input.substring(input.length()-i,input.length()-i+1));
            for (int j=0;j<index-2;j++){
                result.append(" ");
            }
            result.append(input.substring(row+i,row+i+1)+"\n" );
        }
        for(int i = input.length()-row;i>=row*2;i--){
            result.append(input.substring(i,i+1));
        }
        System.out.println(result.toString());
    }

}
