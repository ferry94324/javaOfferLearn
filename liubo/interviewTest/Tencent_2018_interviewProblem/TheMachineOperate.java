package liubo.interviewTest.Tencent_2018_interviewProblem;



import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TheMachineOperate{
    static class Node {
        int t;
        int w;
    }
    public static void main(String[] args) {
    /**
                  * 输入：一：机器数和任务数 二：每个机器的最大工作时间和机器等级 三：每个任务的工作时间和等级
                  */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Node mach[] = new Node[n]; // 未初始化的对象数组
        Node task[] = new Node[m];
        for (int i = 0; i < n; i++) {
            mach[i] = new Node(); // 初始化对象
            mach[i].t = scanner.nextInt();
            mach[i].w = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            task[i] = new Node();
            task[i].t = scanner.nextInt();
            task[i].w = scanner.nextInt();
        }
        scanner.close();
        // 降序，优先完成时间大的或者难度大的，效益高
        Arrays.sort(mach, new Comparator<Node>() {
        public int compare(Node a, Node b) {
        // TODO Auto-generated method stub
                if (a.t == b.t) {
                    return b.w - a.w;
                }
                return b.t - a.t; // 降序
        }
        });

        // 记录可以完成相应难度等级的任务
        int difficult[] = new int[105];
        int j=0, num=0;
        long sum=0;
        for(int i=0; i<m; i++){

    // 由于按时间和难度降序，某个机器能完成前面的任务肯定也能完成后面的
            while (j<n && mach[j].t>=task[i].t) {
            difficult[mach[j].w]++;//记录可以完成当前难度的机器数
                j++;
            }

     // 如果当期任务难度能被完成且还有机器可以完成
            for(int k=task[i].w; k<=100; k++){
                // 机器是否空闲
                if (difficult[k]>0) {
                    num++;
                    sum += 200*task[i].t +3*task[i].w;
                    difficult[k]--;
                    break;
                }
            }
        }
        System.out.println(num + " " + sum);
    }
}