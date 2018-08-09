package liubo.jzOffer.f04_PrintOneToMaxNNum;

import java.util.Arrays;

public class PrintOneToMaxNNumSolution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        PrintOneToMaxNNumSolution test = new PrintOneToMaxNNumSolution();
        test.printToMax(3);
        //test.printToMax2(3);

    }

    /**
     * 字符串上模拟加法
     *
     * @param n
     */
    public void printToMax(int n) {
        if (n < 0)
            return;
        char[] number = new char[n];
//		初始化
//		for(int i = 0; i < n; i++)
//			number[i] = '0';
        Arrays.fill(number, '0');
        while (!increment(number)) {
            printNumber(number);
        }
        return;

    }

    public boolean increment(char[] num) {
        boolean isOverflow = false;
        int size = num.length;
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int temp = num[i] - '0' + carry;
            if (i == size - 1)
                temp++;
            if (temp >= 10) {
                if (i == 0) //最高位溢出
                    isOverflow = true;
                else {
                    temp -= 10;
                    carry = 1;
                    num[i] = (char) ('0' + temp);
                }
            } else {
                num[i] = (char) ('0' + temp);
                break;
            }
        }
        return isOverflow;
    }

    public void printNumber(char[] num) {
        int size = num.length;
        int i = 0;
        while (i < size && num[i] == '0') //i < size在前，否则越界
            i++;
        //char[] printNum = new char[size - i];
        //System.arraycopy(num, i, printNum, 0, size - i);//复制数组
        if (i == size)//不打印全0
            return;
        char[] printNum = Arrays.copyOfRange(num, i, size);//复制数组
        System.out.println(printNum);
    }

    /**
     * 字符每一位进行全排列
     *
     * @param n
     */
    public void printToMax2(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        printOrder(number, n, 0);
    }

    public void printOrder(char[] number, int n, int loc) {
        if (loc == n) return;
        for (int i = 0; i <= 9; i++) {
            number[loc] = (char) ('0' + i);
            if (loc == n - 1) {
                printNumber(number);
            }
            printOrder(number, n, loc + 1);
        }

    }
}
