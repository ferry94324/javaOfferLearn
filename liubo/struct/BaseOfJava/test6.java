package liubo.struct.BaseOfJava;

import java.util.Scanner;

public class test6 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {//注意while处理多个case
                int n = in.nextInt();
                int k = in.nextInt();
                int m[] = new int[n];
                int maxValue = 100000;
                int index = 0;
                for(int i=0;i<n;i++){
                    m[i] = in.nextInt();
                    if(m[i]<maxValue){
                        maxValue = m[i];
                        index = i;
                    }
                }
                int sum_end = 0;
                int sum_start = 0;
                if((n-(index+k-1)%k==0)){
                    sum_end  =(n-(index+k-1))/k;
                }else{
                    sum_end = (n-(index+k-1))/k+1;
                }
                if((index-1)%k==0){
                    sum_start = (index-1)/k;
                }else{
                    sum_start = (index-1)/k+1;
                }
                System.out.println(sum_start+sum_end);
            }

        }
}
