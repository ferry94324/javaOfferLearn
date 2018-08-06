package liubo.sort;

import java.util.Arrays;

/**
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻
 * 的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：
 * 每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换
 */
public class BubbleSort {
    public static void main(String[] args) {
        int r[] = {50,13,55,97,27,38,49,65};
        System.out.println("排序前的记录："+Arrays.toString(r));
        bubbleSort_b(r);
        System.out.println("排序后的记录："+Arrays.toString(r));

    }
    public static void bubbleSort_a(int a[]){
        int i = a.length-1;
        while(i>0){
            int pos= 0;
            for(int j = 0;j<i;j++){
                if(a[j]>a[j+1]){
                    pos = j;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            i = pos;
            System.out.println("排序记录："+Arrays.toString(a));
        }
    }
    public static void bubbleSort_b(int a[]){
        int n = a.length-1;
        int low = 0;
        int high= n -1; //设置变量的初始值
        int tmp,j;
        while (low < high) {
            for (j= low; j< high; j++) //正向冒泡,找到最大者
                if (a[j]> a[j+1]) {
                    tmp = a[j]; a[j]=a[j+1];a[j+1]=tmp;
                }
            high--;                 //修改high值, 前移一位
            for ( j=high; j>low; j--) //反向冒泡,找到最小者
                if (a[j]<a[j-1]) {
                    tmp = a[j]; a[j]=a[j-1];a[j-1]=tmp;
                }
            low++;                  //修改low值,后移一位
            System.out.println("排序记录："+Arrays.toString(a));
        }
    }
}