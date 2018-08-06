package liubo.jzOffer.b01_searchInTwoDimensionalArrays;

public class SearchInArrays {
    public boolean Find1(int target,int [][]array){
        int row = array.length-1;
        int clum = array[0].length-1 ;
        int hang = 0;
        int lie = clum;
        boolean flag = false;
        while(hang<row&&lie>0){
            int value = array[hang][lie];
            if(target==value){
                flag = true;
                break;
            }else if(target>value){
                hang++;
            }else{
                lie--;
            }
        }
        return flag;

    }
    public boolean Find2(int target, int [][] array) {
        int flag = 0;
        for(int i=array.length-1; i>=0; i--){
            for(int j=flag; j<array[i].length; j++){
                if(target == array[i][j]){
                    return true;
                } else if(target<array[i][j]){
                    flag = j;
                    break;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int array[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int target = 22;
        SearchInArrays se = new SearchInArrays();
        boolean f = se.Find2(target,array);
        System.out.println("-----"+f);
    }
}
