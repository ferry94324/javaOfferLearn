package liubo.interviewTest.niuniuchaogupiao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[1005];
        int[][]c = new int[1005][2];
        for (int i =0;i<m;i++){
            dp[i] = i;
        }
        for (int i = 0;i<n;i++){
            c[i][0]=sc.nextInt();
            c[i][1] = sc.nextInt();
            for (int j = c[i][0];j<m;j++){
                dp[j] = Math.max(dp[j],dp[j-c[i][0]]+c[i][1]);
            }
        }
        System.out.println(dp[m]-m);
    }
}
