package liubo.interviewTest.alibaba_kuaidi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point{
    private int a;
    private int b;
    public boolean used =true;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


    public int getXY(Point point){
        return Math.abs(point.getA()-this.a)+Math.abs(point.getB()-this.b);
    }
    @Override
    public String toString() {
        return "Point{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
public class Main {



    // 总的距离
    static int sum=0;

    static int min=9999999;
    //要移除的坐标
    static int index;

    static int number=0;

    static List<Point> list = new ArrayList<>();


    static int calculate() {
        Point start = new Point(0,0);
        Point start1 = new Point(0,0);
        while (number!=list.size()){
            start=getNext(start);
//            System.out.println(sum);
        }
        int ss = sum+start.getXY(start1);
        return ss;

    }


    static Point getNext(Point start){

        for (int i = 0;i<list.size();i++){
            Point point = list.get(i);

            if (point.isUsed()){
                if (min>start.getXY(point)){
                    min=start.getXY(point);
                    index = i;
                }
            }
        }

        sum+=min;
        min=99999;
        ++number;
        start = list.get(index);
        start.setUsed(false);
        return start;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            String temp= scanner.nextLine();
            locations[index++] =temp;
            String[] numberStr = temp.split(",");
            int a = Integer.parseInt(numberStr[0]);
            int b = Integer.parseInt(numberStr[1]);
            list.add(new Point(a,b));
        }
//        list.stream().forEach(System.out::println);

        System.out.println(calculate());
    }
}
