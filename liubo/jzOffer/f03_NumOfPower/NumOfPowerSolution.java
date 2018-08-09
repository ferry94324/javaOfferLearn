package liubo.jzOffer.f03_NumOfPower;

public class NumOfPowerSolution {
    public double powerSolution(double base,int exponent) throws Exception {
        double result = 1;
        if (base==0){
            throw new Exception("底数不能为0");
        }
        if (exponent==0){
            result = 1;
        }else if (exponent>0){
            for (int i =1;i<=exponent;i++){
                result *= base;
            }
        }else{
            for (int i = 1;i<=(-exponent);i++){
                result *= base;
            }
            result = 1.0/result;
        }
        return result;
    }
    public double powerSolution2(double base,int exponent) throws Exception {
        double result = 1;
        if (base==0){
            throw new Exception("底数不能为0");
        }else if(exponent==0){
            return 1;
        }
        int n = exponent>0?exponent:(-exponent);
        //右移一位表示除2的1次方，所以右移n位表示除2的n次
        //左移一位表示乘2的1次方，所以左移n位表示乘2的n次
        result = powerSolution2(base,n>>1); //使用右移运算符代替了除以2
        result *= result;
        if ((n&0x1)==1){  //也可用位与运算符代替求余运算符，因为位运算符效率高。同时==的优先级要高
            result *= base;
        }
        return exponent>0?result:1.0/result;
    }
    public static void main(String[] args) throws Exception {
        NumOfPowerSolution np = new NumOfPowerSolution();
        double res = np.powerSolution(2,-2);
        System.out.println(res);
    }
}
