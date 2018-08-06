package liubo.jzOffer.a01_blockReplaceInSpace;

public class ReplaceBlankSolution {
    public String replaceBlank(StringBuffer str){
        int blankNum = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                blankNum++;
            }
        }
        int oldStrLength = str.length();
        int newStrLength = oldStrLength+blankNum*2;
        int oldindex = oldStrLength-1;
        int newindex = newStrLength-1;
        str.setLength(newStrLength);
        for(;oldindex>0&&oldindex<newStrLength;oldindex--){
            if (str.charAt(oldindex)==' '){
                str.setCharAt(oldindex--,'0');
                str.setCharAt(oldindex--,'2');
                str.setCharAt(oldindex--,'%');
            }else{
                str.setCharAt(newindex--,str.charAt(oldindex));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceBlankSolution rbs = new ReplaceBlankSolution();
        StringBuffer str = new StringBuffer("we are happy!");
        String str2 = rbs.replaceBlank(str);
        System.out.println("str2:"+str2);
    }
}

