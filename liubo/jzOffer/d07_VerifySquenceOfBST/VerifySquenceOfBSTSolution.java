package liubo.jzOffer.d07_VerifySquenceOfBST;

public class VerifySquenceOfBSTSolution {
    public boolean VerifySquenceOfBST(int sequence[],int start,int length){
        if (sequence == null||length<0){
            return false;
        }
        int root = sequence[length];
        int i =start;
        for (;i<length;i++){
            if (sequence[i]>root){
                break;
            }
        }
        int j = i;
        for (;j<length;j++){
            if (sequence[j]<root){
                return false;
            }
        }
        boolean left = true;
        if (i>0){
            left = VerifySquenceOfBST(sequence,start,i);
        }
        boolean right = true;
        if (i<length){
            right = VerifySquenceOfBST(sequence,i,length-1);
        }
        return (left&&right);
    }

    public static void main(String[] args) {
        VerifySquenceOfBSTSolution verifySquenceOfBSTSolution = new VerifySquenceOfBSTSolution();
        int []sequence = {7,4,6,5};
        boolean result = verifySquenceOfBSTSolution.IsTreeBST(sequence,0,sequence.length-1);
        System.out.println(result);
    }
    public boolean IsTreeBST(int sequence[],int start,int length ){
        if(length <= start) return true;
        int i = start;
        for (; i < length; i++) {
            if(sequence[i] > sequence[length]) break;
        }
        for (int j = i; j < length; j++) {
            if(sequence[j] < sequence[length]) return false;
        }
        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, length-1);
    }

}
