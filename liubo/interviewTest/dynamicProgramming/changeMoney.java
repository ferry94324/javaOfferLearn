package liubo.interviewTest.dynamicProgramming;

public class changeMoney {
    /**
     * 暴力递归过程：就是首先将arr[0]固定
     * 1.用0张5元的货币，让剩下的[10,25,1]组成剩下的1000，最终的方法数记为res1
     * 2.用1张5元的货币，让剩下的[10,25,1]组成剩下的995，最终的方法数记为res2
     * 3.用2张5元的货币，让剩下的[10,25,1]组成剩下的990，最终的方法数记为res3
     * ...
     * 201.用200张5元的货币，让剩下的[10,25,1]组成剩下的0，最终的方法数记为res201
     * 这里的res1是这一行的递归结果，里面有后续内容。
     * 这就是暴力递归过程。
     * @param arr
     * @param aim
     * @return
     */
    public int coins1(int[] arr, int aim){
        if (arr==null||arr.length==0||aim<0){
            return 0;
        }
        return process1(arr,0,aim);
    }
    public int process1(int[] arr,int index, int aim){
        int res = 0;
        if (index == arr.length){
            res = aim==0?1:0;
        }else{
            for (int i =0;arr[index]*i<=aim;i++){
                res+=process1(arr,index+1,aim-arr[index]*i);
            }
        }
        return res;
    }

    /**
     * 记忆搜索方法
     * 1.每次计算完一个p(index,aim)后，都将结果放入map中，index和aim组成共同的KEY，返回结果为Value。
     * 2.要进入一个递归过程p（index，aim），先以index和aim注册的key在map中查询是否存在value，如果存在，直接取值，否则进行递归计算
     * @param arr
     * @param aim
     * @return
     */
    public int coins2(int arr[],int aim){
        if (arr==null||arr.length==0||aim<0){
            return 0;
        }
        int [][]map = new int[arr.length+1][aim+1];
        return process2(arr,0,aim,map);
    }
    public int process2(int []arr,int index,int aim,int[][] map){
        int res = 0;
        if (index == arr.length){
            res = aim==0?1:0;
        }else{
            int mapValue = 0;
            for (int i =0;arr[index]*i<=aim;i++){
                mapValue = map[index+1][aim-arr[index]*i];
                if (mapValue!=0){
                    res+=mapValue==-1?0:mapValue;
                }else {
                    res+=process2(arr,index+1,aim-arr[index]*i,map);
                }
            }
        }
        map[index][aim] = res == 0?-1:res;
        return res;
    }

    /**
     *
     * 动态规划方案
     *
     */
    public int coins3(int[]arr,int aim){
        if (arr==null||arr.length==0||aim<0){
            return 0;
        }
        int[][] dp = new int[arr.length][aim+1];
        for (int i = 0;i<arr.length;i++){
            dp[i][0] = 1;  //第一列都是1
        }

        for (int j = 1;arr[0]*j<=aim;j++){
            dp[0][arr[0]*j] = 1;  //第一行中的只有是arr[0]的倍数才是1
        }
        int num =0;
        for (int i =1;i<arr.length;i++){
            for (int j=1;j<=aim;j++){
                num=0;
                for (int k = 0;j-arr[i]*k>=0;k++){
                    num+=dp[i-1][j-arr[i]*k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length-1][aim];
    }
    public static void main(String[] args) {
        changeMoney cm = new changeMoney();
        int[] arr = {5,10,25,1};
        int aim = 1000;
        int res = cm.coins1(arr,aim);
        int res2 = cm.coins2(arr,aim);
        int sum = cm.coins3(arr,aim);
        System.out.println("res2== "+res2);
        System.out.println("res== "+res);
        System.out.println("sum==="+sum);
    }
    /**
     * 1.实现暴力递归方法
     * 2.在暴力搜索方法的函数中看看哪些参数可以代表递归过程。
     * 3.找到代表递归过程的参数后，记忆搜索的方法就非常容易实现了
     * 4.通过分析记忆搜索方法改出动态规划方法，进而看看是否可以化简，如果可以化简，还能实现时间复杂度更低的动态规划问题
     * 动态规划方法的关键点：
     * 1.最优化原理，也就是最优子结构性质。这指的是一个最优化策略具有这样的性质，不论过去状态和决策如何，对前面的决策
     *   所形成的状态而言，余下的诸多决策必须构成最优策略。简单来说就是如果一个最优化策略的子策略总是最优的，如果一个
     *   问题满足最优化原理，称为最优化子结构性质。
     * 2.无后效性。指的是某状态下决策的收益，与状态和决策有关，与达到该状态的方式无关。
     * 3.子问题的重叠性。关键在于解决问题的冗余问题。我也知道
     */

}
