package liubo.interviewTest.Tencent_2018_interviewProblem;

import java.util.Scanner;

/**
 * 题目：有X首长度为A的歌和Y首长度为B的歌，求这些歌组成一个长度正好为K的歌单，求组成歌单的组合数。
 * 解析：其实就是求组合数，
 * 比如长度为3的有x个、长度为4的有y个，求最后长度为k的。k = i*1+j*4。只需要遍历（i 从0到x）（j从0到y）只有等式成立，就得到一组(i,j)。
 * i是从x中选则i个，所以可能性有C<x,i>，比如10个里面选3个，就是C<10,3> = 10*9*8/(3*2*1)，同理可求C<y，j>。两个数相乘，就是选定(i,j)的种数。
 * 数学归纳法可知C(n,k) = C(n-1,k) + C(n-1,k-1）；
 * 正好对应杨辉三角。
 * 然后就可以判断条件
 *  i * A <= K : 分数不能超过K）&&（（ K - i* A）% B == 0  ：确保分数相加等于K） &&  （（ K - i* A）/  B  <= Y  :不能超过Y歌的数目），
 *  将满足条件的结果相加起来就是最后的结果。
 */
public class MusicOfQItem {
    public static final long mod = 1000000007;
    public static void main(String[] args) {
        MusicOfQItem mt = new MusicOfQItem();
        long c[][] = mt.yanghuiTrangle();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int x = sc.nextInt();
        int b = sc.nextInt();
        int y = sc.nextInt();
        long ans = 0;
        for (int i =0;i<=x;i++){
            if (i*a<=k&&(k-i*a)%b==0&&(k-i*a)/b<y){
                //对应符合条件的组合数
                ans = (ans+(c[x][i]*c[y][(k-i*a)/b])%mod)%mod;
            }
        }
        System.out.println(ans);

    }
    //杨辉三角：C（m,n） = C(m-1,n-1)+C(m-1,n).这个正好也是组合数一个规律
    public long[][] yanghuiTrangle(){
        long c[][] = new long[101][101];
        c[0][0]  = 1;
        for (int i = 1;i<=100;i++){
            c[i][0]=1;
            for (int j = 1;j<=100;j++){
                c[i][j] = (c[i-1][j-1]+c[i-1][j])%mod;
            }
        }
        return c;
    }
}
