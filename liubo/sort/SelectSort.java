package liubo.sort;

import java.util.Arrays;

public class SelectSort {
    public void swap(int a[],int i,int j){
        if (i==j){
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void SelectSort(int a[]){
        for (int i = 0;i<a.length;i++){
            int k = i;    //存放待排序记录的初始位置
            for (int j = i+1;j<a.length;j++){
                if (a[k]>a[j]){
                    k = j;//找到待排序记录中最小值的位置
                }
            }
            swap(a,k,i);//交换待排序记录中的第一个与最小值位置，并将这个放入有序区
        }
    }
    public void selectTwoSort(int a[]){
        for (int i =0;i<a.length;i++){
            int min = i;
            int max = a.length-i-1;
            for (int j = i+1;j<a.length-i-1;j++){
                //可找到记录的最大值和最小值
                if (a[j]<a[min]){
                    min = j;
                    continue;
                }
                if (a[j]>a[max]){
                    max = j;
                }
            }
            swap(a,min,i);
            swap(a,max,a.length-i-1);
        }
    }
    public static void main(String[] args) {
        SelectSort ss = new SelectSort();
        int[] a = {3,1,5,7,2,4,9,6,10,8};
        System.out.println("排序前的值：");
        System.out.println(Arrays.toString(a));
        ss.selectTwoSort(a);
        System.out.println("排序后的值");
        System.out.println(Arrays.toString(a));
    }
}
