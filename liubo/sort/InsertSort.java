package liubo.sort;

import java.util.Arrays;

/**
 * 步骤如下：
 * 1.将待排序的记录分成有序区和无序区，初始时有序区为待排序记录序列中的第一个记录，无序区包括剩余待排序的记录。
 * 2.将无序区的第一个记录插入到有序区的合适位置中，无序区减少一个记录，有序区增加一个记录。
 * 重复执行2，知道无序区没有记录为止。
 */
public class InsertSort {
    public static void main(String[] args) {
        int r[] = {12,15,9,20,6,31,24};
        System.out.println("排序前的记录："+Arrays.toString(r));
        Insertsort(r);
        System.out.println("排序后的记录："+Arrays.toString(r));
    }
    public static void Insertsort(int a[]){
        //外层循环：待排序记录
        for(int i = 1;i<a.length;i++){
            int flag = a[i]; //flag 是一个辅助空间，用作待插入记录的暂存单元和查找记录的插入位置的过程中的哨兵
            //内层循环：待插入记录逐条与有序记录比较插入
            int j;
            for(j = i;j>0&&flag<a[j-1];j--){
                a[j] = a[j-1];
            }
            a[j] = flag;
            System.out.println("第"+i+"趟排序结果是："+Arrays.toString(a));
        }
    }
}
