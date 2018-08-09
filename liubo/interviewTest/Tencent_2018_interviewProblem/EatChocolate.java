package liubo.interviewTest.Tencent_2018_interviewProblem;

import java.util.Scanner;

public class EatChocolate {
    //这个方法是用来获得当第一天吃x个，过了n天应该有的糖果数。向上取整。
    public int getSum(int x,int n){
        int sum =0;
        for (int i=0;i<n;i++){
            sum +=x;
            x = (x+1)/2;
        }
        return sum;
    }
    //使用二分法，先获取mid，如果当第一天 吃mid个最后一天吃的数目的总数正好是m，那么第一天可以吃mid个
    //如果是小于那么说明第一天吃少了，还可以继续吃，所以这时候可以令low为mid+1，这样重新计算mid，直到得到结果
    //如果大于那么说明第一天吃多了  ，所以需要让high = mid-1，然后再重新计算mid再判断是否合理，最后返回结果。
    public int eatFunction(int n,int m){
        if (n == 1){
            return m;
        }
        int low =1;
        int high = m;
        while(low<high){
            int mid = (low+high+1)/2;
            if (getSum(mid,n)==m){
                return mid;
            }else if (getSum(mid,n)<m){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        EatChocolate ec = new EatChocolate();
        int sum = ec.getSum(5,n);
        int firstEat = ec.eatFunction(n,m);
        System.out.println(sum);
        System.out.println(firstEat);
    }
}
