package liubo.jzOffer.e01_PrintMatrixInCircle;

import java.util.ArrayList;

public class PrintMatrixInCirCleSolution {
    public ArrayList<Integer> printOneCirCle(int[][] array , int start){
        ArrayList<Integer> oneCircleList = new ArrayList<Integer>();
        int cloums = array[0].length;
        int rows = array.length;
        int endX = cloums-start-1;
        int endY = rows-start-1;
        for (int i = start;i<=endX;i++){
            int number = array[start][i];
            oneCircleList.add(number);
            System.out.print(number+",");
        }
        if (start<endY){
            for (int i = start+1;i<=endY;i++){
                int number = array[i][endX];
                oneCircleList.add(number);
                System.out.print(number+",");
            }
        }
        if (start<endX&&start<endY){
            for (int i = endX-1;i>=start;i--){
                int number = array[endY][i];
                oneCircleList.add(number);
                System.out.print(number+",");
            }
        }
        if (start<endX&&start<endY-1){
            for (int i=endY-1;i>=start+1;i--){
                int number = array[i][start];
                oneCircleList.add(number);
                System.out.print(number+",");
            }
        }
        return  oneCircleList;
    }
    public ArrayList<Integer> PrintMatrixInCircle(int [][]array){
        if (array == null) return null;
        int start = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(array[0].length>start*2&&array.length>start*2){
            ArrayList<Integer> oneCircle = printOneCirCle(array,start);
            result.addAll(oneCircle);
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        PrintMatrixInCirCleSolution printMatrixInCirCleSolution = new PrintMatrixInCirCleSolution();
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> result = printMatrixInCirCleSolution.PrintMatrixInCircle(array);
        System.out.println(result);
    }
}
