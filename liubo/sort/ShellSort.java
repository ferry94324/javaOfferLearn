package liubo.sort;

import java.util.Arrays;

/**
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序.
 * 先将要排序的一组记录按某个增量d（n/2,n为要排序数的个数）分成若干组子序列，每组中记录的下标相差d.对每组中全部元素进行直接插入排序，
 * 然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。继续不断缩小增量直至为1，最后使用直接插入排序完成排序。
 */
public class ShellSort {
    public static void main(String[] args) {
        int r[] = {12,15,9,20,6,31,24};
        System.out.println("排序前的记录："+Arrays.toString(r));
        shellSort(r);
        System.out.println("排序后的记录："+Arrays.toString(r));
    }
    private static void shellSort(int[] a) {
        int dk = a.length/2;
        while( dk >= 1  ){
            ShellInsertSort(a, dk);
            System.out.println("排序记录："+Arrays.toString(a));
            dk = dk/2;
        }
    }
    public static void ShellInsertSort(int a[],int dk){
        for(int i=dk;i<a.length;i++){
            int j;
            int x=a[i];//x为待插入元素
            for(j=i-dk;  j>=0 && x<a[j];j=j-dk){//通过循环，逐个后移一位找到要插入的位置。
                a[j+dk]=a[j];
            }
            a[j+dk]=x;//插入
        }

    }
}